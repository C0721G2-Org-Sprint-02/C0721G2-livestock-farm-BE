package com.project.livestockfarmbe.repository.cage;

import com.project.livestockfarmbe.model.cage.TypeOfCage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeOfCageRepository extends PagingAndSortingRepository<TypeOfCage,Long>{
    List<TypeOfCage> findAll();
}
