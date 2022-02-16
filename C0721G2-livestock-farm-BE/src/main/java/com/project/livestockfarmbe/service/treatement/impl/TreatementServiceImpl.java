package com.project.livestockfarmbe.service.treatement.impl;

import com.project.livestockfarmbe.model.treatement.Treatement;
import com.project.livestockfarmbe.repository.treatement.ITreatementRepository;
import com.project.livestockfarmbe.service.treatement.ITreatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TreatementServiceImpl implements ITreatementService {
    @Autowired
    private ITreatementRepository iTreatementRepository;

    @Override
    public Page<Treatement> findAllTreatementsByFilter(String doctor, String kindOfDisease, String cage, Pageable pageable) {
        return iTreatementRepository.findAllTreatementsByFilter(doctor,kindOfDisease,cage, pageable);
    }

    @Override
    public Treatement saveTreatement(Treatement treatement) {
        return iTreatementRepository.save(treatement);
    }


}
