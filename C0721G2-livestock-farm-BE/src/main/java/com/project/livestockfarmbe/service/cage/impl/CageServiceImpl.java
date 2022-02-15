package com.project.livestockfarmbe.service.cage.impl;

import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.repository.cage.ICageRepository;
import com.project.livestockfarmbe.service.cage.ICageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CageServiceImpl implements ICageService {
    @Autowired
    ICageRepository iCageRepository;

    @Override
    public Page<Cage> findAllCagePage(Pageable pageable) {
        return this.iCageRepository.listCages(pageable);
    }

    @Override
    public Page<Cage> findAllCagePageSearch(Pageable pageable, String search) {
        return this.iCageRepository.searchCageByEmployeeNameOrDayOponeOrTypeOfCage(pageable,search);
    }

    @Override
    public Optional<Cage> findByIdOp(String id) {
        return this.iCageRepository.findById(id);
    }
}
