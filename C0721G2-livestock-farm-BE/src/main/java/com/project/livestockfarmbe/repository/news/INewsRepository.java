package com.project.livestockfarmbe.repository.news;

import com.project.livestockfarmbe.model.news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INewsRepository extends JpaRepository< News, String > {
    // TaiVD 1.3 List of news
    @Query(value = " select * from news" +
            " where (title like  concat('%',trim(:title),'%')) " +
            " and (type_of_news_id like concat('%',:typeNews,'%')) " +
            " and (deleted = false)  ",
            nativeQuery = true, countQuery = " select count(*)  from news " +
            " where (title like  concat('%',trim(:title),'%')) " +
            " and (type_of_news_id like concat('%',:typeNews,'%'))" +
            " and (deleted = false) ")
    Page< News > findAllNews(@Param("title") String title,
                             @Param("typeNews") String typeNews,
                             Pageable pageable);

    // TaiVD 1.3 Show news detail
    @Query(value = " select * from news where id =:id and deleted = false ", nativeQuery = true)
    Optional< News > findNewsById(@Param("id") String id);

    //Đây là phần của Thịnh


}
