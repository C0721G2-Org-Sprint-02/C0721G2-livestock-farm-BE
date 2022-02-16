package com.project.livestockfarmbe.repository.individual;

import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.model.treatement.Treatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIndividualRepository extends JpaRepository<Individual, String > {
}
