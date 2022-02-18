package com.project.livestockfarmbe.service.news;

import com.project.livestockfarmbe.model.news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface INewsService {
    // TaiVD 1.3 Show news detail
    Optional<News> findNewsById(String id);

    // TaiVD 1.3 List of news
    Page<News> findAllNews(@Param("title") String title, Pageable pageable);

    void deleteNewsById(String id);

    void saveNews(News news);
}
