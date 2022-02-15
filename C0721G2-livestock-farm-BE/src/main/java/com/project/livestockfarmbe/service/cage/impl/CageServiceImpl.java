package com.project.livestockfarmbe.service.cage.impl;

import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.repository.cage.ICageRepository;
import com.project.livestockfarmbe.service.cage.ICageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CageServiceImpl implements ICageService {
    @Autowired
    ICageRepository iCageRepository;

    @Override
    public Iterable<Cage> findAllCage() {
        return iCageRepository.findAll();
    }

    @Override
    public Optional<Cage> findCageById(String id) {
        return iCageRepository.findById(id);
    }

    @Override
    public Cage saveCage(Cage cage) {
        return iCageRepository.save(cage);
    }

    public Boolean checkCageExist(String id) {
        return iCageRepository.existsById(id);
    }




//    public Boolean checkEmployeeExist(String id) {
//        return iCageRepository.existsByEmployee(id);
//    }
}
