package com.project.livestockfarmbe.service.cage;

import com.project.livestockfarmbe.model.cage.Cage;

import java.util.Optional;

public interface ICageService {
    // Dùng chung
    Iterable<Cage> findAllCage();

    // Dùng chung
    Optional<Cage> findCageById(String id);

    //Tùng
    Cage saveCage(Cage cage);

}
