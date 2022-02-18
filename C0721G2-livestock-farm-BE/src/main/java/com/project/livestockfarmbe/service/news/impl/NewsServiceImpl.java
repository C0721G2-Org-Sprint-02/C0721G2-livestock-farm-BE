package com.project.livestockfarmbe.service.news.impl;

import com.project.livestockfarmbe.model.news.News;
import com.project.livestockfarmbe.repository.news.INewsRepository;
import com.project.livestockfarmbe.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    INewsRepository iNewsRepository;

    @Override
    public Optional<News> findNewsById(String id) {
        return this.iNewsRepository.findNewsById(id);
    }

    @Override
    public Page<News> findAllNews(String title, Pageable pageable) {
        return this.iNewsRepository.findAllNews(title, pageable);
    }

    @Override
    public void deleteNewsById(String id) {
        iNewsRepository.deleteById(id);
    }

    @Override
    public void saveNews(News news) {
        iNewsRepository.save(news);
    }
}
