package com.project.livestockfarmbe.repository.news;

import com.project.livestockfarmbe.model.news.TypeOfNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeOfNewsReposityory extends JpaRepository<TypeOfNews, Long> {
    List<TypeOfNews> findAll();
}
