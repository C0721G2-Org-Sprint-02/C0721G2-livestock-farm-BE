package com.project.livestockfarmbe.service.individual;

import com.project.livestockfarmbe.model.individual.Individual;
import org.springframework.data.domain.Page;

public interface IIndividualService {
    Page<Individual> findAllIndividual(int page, int size, String sortField, String sortDirection, String individualId, String cageId, String dateIn, String dateOut, String status);

    Individual findIndividualById(String id);

    void deleteIndividual(Individual individual);

    void save(Individual individual);
}
