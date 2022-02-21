package com.project.livestockfarmbe.service.individual;

import com.project.livestockfarmbe.dto.IndividualDTO;
import com.project.livestockfarmbe.model.individual.Individual;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IIndividualService {
    //thiện nhỏ//
    Individual save(IndividualDTO individualDTO);

    //thiện nhỏ//
    Optional<Individual> findIndividualWithId(String id);

    //anh hiền//
    void deleteIndividual(Individual individual);
    //anh hiền//
    Individual findIndividualById(String id);
    //anh hiền//
    Page<Individual> findAllIndividual(int page, int size, String sortField, String sortDirection, String individualId, String cageId, String dateIn, String dateOut, String status);

}
