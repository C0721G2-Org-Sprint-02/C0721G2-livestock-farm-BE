package com.project.livestockfarmbe.repository.news;

import com.project.livestockfarmbe.model.news.TypeOfNews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITypeOfNewsReposityory extends JpaRepository<TypeOfNews , Long> {
    List<TypeOfNews> findAll();
}
