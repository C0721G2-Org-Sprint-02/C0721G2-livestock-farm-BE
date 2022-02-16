package com.project.livestockfarmbe.service.treatement;

import com.project.livestockfarmbe.model.treatement.Treatement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITreatementService {


    // 7.2.1 list treatement KhaiPN
    Page<Treatement> findAllTreatementsByFilter(String doctor, String kindOfDisease, String cage, Pageable pageable);

    // 7.2.2 add treatement KhaiPN
    Treatement saveTreatement(Treatement treatement);


}
