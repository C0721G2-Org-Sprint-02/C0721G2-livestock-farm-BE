package com.project.livestockfarmbe.repository.cage;

import com.project.livestockfarmbe.model.cage.TypeOfCage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeOfCageRepository extends JpaRepository<TypeOfCage,Long> {
}
