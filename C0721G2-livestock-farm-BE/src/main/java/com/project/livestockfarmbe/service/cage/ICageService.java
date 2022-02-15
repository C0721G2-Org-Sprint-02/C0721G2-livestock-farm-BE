package com.project.livestockfarmbe.service.cage;

import com.project.livestockfarmbe.model.cage.Cage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICageService {
    Page<Cage> findAllCagePage(Pageable pageable);
    Page<Cage> findAllCagePageSearch(Pageable pageable, String search);
    Optional<Cage> findByIdOp(String id);

}
