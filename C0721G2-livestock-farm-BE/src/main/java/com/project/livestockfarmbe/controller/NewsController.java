package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.model.news.News;
import com.project.livestockfarmbe.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private INewsService newsService;

    // TaiVD 1.3 Show news detail
    @GetMapping("/{id}")
    public ResponseEntity< News > findNewById(@PathVariable(value = "id") String id) {
        Optional< News > news = newsService.findNewsById(id);
        return news.map(value
                -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    // TaiVD 1.3 List of news
    @GetMapping("")
    public ResponseEntity< Page< News > > showAllNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") String typeNews) {
        Pageable pageable = PageRequest.of(page, 12, Sort.by("post_date").descending());
        Page< News > newsPage = newsService.findAllNews(title, typeNews, pageable);
        System.out.println(typeNews + "Test");

        if (newsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsPage, HttpStatus.OK);
    }
}
