package com.project.livestockfarmbe.service.buyIndividual;

import com.project.livestockfarmbe.model.buyIndividual.BuyIndividual;
import org.springframework.stereotype.Service;

@Service
public interface IBuyIndividualService {
    void saveBuyIndividual(BuyIndividual buyIndividual);
}
