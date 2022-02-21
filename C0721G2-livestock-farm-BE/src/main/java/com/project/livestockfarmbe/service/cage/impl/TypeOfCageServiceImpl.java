package com.project.livestockfarmbe.service.cage.impl;


import com.project.livestockfarmbe.model.cage.TypeOfCage;
import com.project.livestockfarmbe.repository.cage.ITypeOfCageRepository;
import com.project.livestockfarmbe.service.cage.ITypeOfCageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfCageServiceImpl  implements ITypeOfCageService {
    @Autowired
    ITypeOfCageRepository typeOfCageRepository;

    @Override
    public List<TypeOfCage> findAllTypeOfCage() {
        return typeOfCageRepository.findAll();
    }
}
