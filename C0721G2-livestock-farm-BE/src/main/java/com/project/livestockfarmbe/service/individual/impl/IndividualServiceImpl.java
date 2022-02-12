package com.project.livestockfarmbe.service.individual.impl;

import com.project.livestockfarmbe.dto.IndividualDTO;
import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.repository.individual.IIndividualRepository;
import com.project.livestockfarmbe.service.individual.IIndividualService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndividualServiceImpl implements IIndividualService {
    @Autowired
    IIndividualRepository iIndividualRepository;

    @Override
    public Individual save(IndividualDTO individualDTO) {
        Individual individual = new Individual();
        BeanUtils.copyProperties(individualDTO,individual);
        return iIndividualRepository.save(individual);
    }

    @Override
    public Optional<Individual> findIndividualById(String id) {
        return iIndividualRepository.findIndividualById(id);
    }

}
