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
    private INewsRepository newsRepository;

    // TaiVD 1.3 Show news detail
    @Override
    public Optional< News > findNewsById(String id) {
        return newsRepository.findNewsById(id);
    }

    // TaiVD 1.3 List of news
    @Override
    public Page< News > findAllNews(String title, String typeNews, Pageable pageable) {
        return newsRepository.findAllNews(title,typeNews, pageable);
    }
}
