package com.project.livestockfarmbe.repository.cage;


import com.project.livestockfarmbe.model.cage.Cage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICageRepository extends PagingAndSortingRepository<Cage,String> {
}
