package com.project.livestockfarmbe.service.buyIndividual.impl;

import com.project.livestockfarmbe.model.buyIndividual.BuyIndividual;
import com.project.livestockfarmbe.repository.buyIndividual.IBuyIndividualRepository;
import com.project.livestockfarmbe.service.buyIndividual.IBuyIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyIndividualServiceImpl implements IBuyIndividualService {
    @Autowired
    IBuyIndividualRepository iBuyIndividualRepository;

    @Override
    public void saveBuyIndividual(BuyIndividual buyIndividual) {
        this.iBuyIndividualRepository.save(buyIndividual);
    }
}