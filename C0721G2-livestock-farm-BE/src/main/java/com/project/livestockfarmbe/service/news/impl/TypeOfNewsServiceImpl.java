package com.project.livestockfarmbe.service.news.impl;

import com.project.livestockfarmbe.model.news.TypeOfNews;
import com.project.livestockfarmbe.repository.news.ITypeOfNewsReposityory;
import com.project.livestockfarmbe.service.news.ITypeOfNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfNewsServiceImpl implements ITypeOfNewsService {

    @Autowired
    ITypeOfNewsReposityory iTypeOfNewsReposityory;

    @Override
    public List<TypeOfNews> findAll() {
        return this.iTypeOfNewsReposityory.findAll();
    }
}
