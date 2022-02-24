package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.NewsDTO;
import com.project.livestockfarmbe.dto.NewsEditDTO;
import com.project.livestockfarmbe.dto.TypeOfNewsDTO;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.model.news.News;
import com.project.livestockfarmbe.model.news.TypeOfNews;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import com.project.livestockfarmbe.service.news.INewsService;
import com.project.livestockfarmbe.service.news.ITypeOfNewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @Autowired
    private ITypeOfNewsService typeOfNewsService;

    @Autowired
    private IEmployeeService employeeService;

    // TaiVD 1.3 Show news detail
    @GetMapping("/{id}")
    public ResponseEntity<News> findNewById(@PathVariable(value = "id") String id) {
        Optional<News> news = newsService.findNewsById(id);
        return news.map(value
                -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    // TaiVD 1.3 List of news
    @GetMapping("/list")
    public ResponseEntity<Page<News>> showAllNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") String typeNews) {
        Pageable pageable = PageRequest.of(page, 12, Sort.by("post_date").descending());
        Page<News> newsPage = newsService.findAllNews(title, typeNews, pageable);
        System.out.println(typeNews + "Test");

        if (newsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }
    // Phần dưới này là của ThinhTP

    @GetMapping(value = "/typeofnews")
    public ResponseEntity<List<TypeOfNews>> getTypeOfNews() {
        List<TypeOfNews> typeOfNews = typeOfNewsService.findAll();
        if (typeOfNews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeOfNews, HttpStatus.OK);
    }


    @GetMapping("/edit/{id}")
    public ResponseEntity<Object> findNewsByIdThinh(@PathVariable(value = "id") String id) {
        Optional<News> newsDTOOptional = newsService.findNewsById(id);
        if (!newsDTOOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        NewsDTO newsDTO = new NewsDTO();
        BeanUtils.copyProperties(newsDTOOptional.get(), newsDTO);
        TypeOfNewsDTO typeOfNewsDTO = new TypeOfNewsDTO(newsDTOOptional.get().getTypeOfNews().getId(), newsDTOOptional.get().getTypeOfNews().getName());
        newsDTO.setTypeOfNewsDTO(typeOfNewsDTO);
        return new ResponseEntity<>(newsDTO, HttpStatus.OK);
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


        //  Set Employee
        Employee employee = new Employee();
        System.out.println(employee.toString());
        employee.setId(newsDTO.getEmployeeId());
        news.setEmployee(employee);

        // Set datetime create
        news.setPostDate(LocalDateTime.now());
        System.out.println(news);
        this.newsService.saveNews(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ThinhTP 2.2.2 Edit news
    @PatchMapping("/edit/{id}")
    public ResponseEntity<Object> editNews(@RequestBody @Valid NewsEditDTO newsDTO,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        News news = new News();
        BeanUtils.copyProperties(newsDTO, news);

        TypeOfNews typeOfNews = new TypeOfNews();
        typeOfNews.setId(newsDTO.getTypeOfNewsDTO().getId());
        news.setTypeOfNews(typeOfNews);

//        news.setImage(newsDTO.getImage());

        //Set time
        news.setPostDate(LocalDateTime.now());
        System.out.println(news);
        System.out.println(newsDTO.toString());

        this.newsService.saveNews(news);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

}
