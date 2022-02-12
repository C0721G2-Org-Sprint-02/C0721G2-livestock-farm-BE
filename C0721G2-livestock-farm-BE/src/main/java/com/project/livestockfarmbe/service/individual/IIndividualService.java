package com.project.livestockfarmbe.service.individual;

import com.project.livestockfarmbe.dto.IndividualDTO;
import com.project.livestockfarmbe.model.individual.Individual;

import java.util.Optional;

public interface IIndividualService {
    Individual save(IndividualDTO individualDTO);
    Optional<Individual> findIndividualById(String id);
}
