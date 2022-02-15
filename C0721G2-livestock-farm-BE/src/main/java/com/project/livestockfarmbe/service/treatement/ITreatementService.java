package com.project.livestockfarmbe.service.treatement;

import com.project.livestockfarmbe.model.treatement.Treatement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITreatementService {


    // 5.6.1 KhaiPN
    Page<Treatement> findAllTreatementsByFilter(String doctor, String kindOfDisease, String cage, Pageable pageable);


}
