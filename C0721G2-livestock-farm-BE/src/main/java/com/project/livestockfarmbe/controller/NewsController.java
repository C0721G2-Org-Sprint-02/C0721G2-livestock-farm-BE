package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.NewsDTO;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.model.news.News;
import com.project.livestockfarmbe.model.news.TypeOfNews;
import com.project.livestockfarmbe.service.news.INewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private INewsService newsService;


    // TaiVD 1.3 Show news detail
    @GetMapping("/{id}")
    public ResponseEntity<News> findNewById(@PathVariable(value = "id") String id) {
        Optional<News> news = newsService.findNewsById(id);
        return news.map(value
                -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    // TaiVD 1.3 List of news
    @GetMapping("")
    public ResponseEntity<Page<News>> showHistoryPostNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "", value = "title") String title) {
        Pageable pageable = PageRequest.of(page, 7, Sort.by("post_date").descending());
        Page<News> newsPage = newsService.findAllNews(title, pageable);
        if (newsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }

    // ThinhTP 2.2.3 Delete of news
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<News> delete(@PathVariable String id) {
        Optional<News> newsOptional = this.newsService.findNewsById(id);
        if (!newsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        newsService.deleteNewsById(id);
        return new ResponseEntity<>(newsOptional.get(), HttpStatus.OK);
    }

    // ThinhTP 2.2.1 Create news
    @PostMapping("/create")
    public ResponseEntity<Object> createNews(@RequestBody @Valid NewsDTO newsDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        News news = new News();
        BeanUtils.copyProperties(newsDTO, news);

        //Type of news
        TypeOfNews typeOfNews = new TypeOfNews();
        typeOfNews.setId(newsDTO.getTypeOfNewsDTO().getId());
        news.setTypeOfNews(typeOfNews);

        // Set Employee
        Employee employee = new Employee();
        employee.setId(newsDTO.getEmployee().getId());

        // Set datetime create
        news.setPostDate(LocalDateTime.now());
        System.out.println(news);
        this.newsService.saveNews(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ThinhTP 2.2.2 Edit news
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Object> editNews(@RequestBody @Valid NewsDTO newsDTO,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        News news = new News();
        BeanUtils.copyProperties(newsDTO, news);


        TypeOfNews typeOfNews = new TypeOfNews();
        typeOfNews.setId(newsDTO.getTypeOfNewsDTO().getId());
        news.setTypeOfNews(typeOfNews);

        // Set Employee
        Employee employee = new Employee();
        employee.setId(newsDTO.getEmployee().getId());

        news.setPostDate(LocalDateTime.now());
        System.out.println(news);
        System.out.println(newsDTO.toString());
        this.newsService.saveNews(news);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
