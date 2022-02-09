package com.project.livestockfarmbe.service.cage.impl;


import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.model.cage.TypeOfCage;
import com.project.livestockfarmbe.repository.cage.ITypeOfCageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeOfCageServiceImpl   {
    @Autowired
    ITypeOfCageRepository typeOfCageRepository;

    public Iterable<TypeOfCage> findAllTypeOfCage() {
        return typeOfCageRepository.findAll();
    }
}
