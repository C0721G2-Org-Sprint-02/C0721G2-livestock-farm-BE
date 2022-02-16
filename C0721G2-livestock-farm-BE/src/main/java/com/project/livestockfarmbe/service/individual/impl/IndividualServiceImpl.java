package com.project.livestockfarmbe.service.individual.impl;

import com.project.livestockfarmbe.repository.individual.IIndividualRepository;
import com.project.livestockfarmbe.repository.treatement.ITreatementRepository;
import com.project.livestockfarmbe.service.individual.IIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualServiceImpl implements IIndividualService {
    @Autowired
    private IIndividualRepository iIndividualRepository;

    @Override
    public boolean existsById(String id) {
        return iIndividualRepository.existsById(id);
    }
}
