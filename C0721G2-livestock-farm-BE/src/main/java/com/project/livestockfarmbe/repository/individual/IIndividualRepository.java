package com.project.livestockfarmbe.repository.individual;

import com.project.livestockfarmbe.model.individual.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IIndividualRepository extends JpaRepository<Individual,Long> {

@Transactional
    @Query(value = "select * from livestock_farm.inviduals where id = :id",nativeQuery = true)

    Optional<Individual> findIndividualById(@Param("id") String id);

}
