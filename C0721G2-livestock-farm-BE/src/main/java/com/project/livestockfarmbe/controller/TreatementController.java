package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.TreatementDTO;
import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.model.treatement.Treatement;
import com.project.livestockfarmbe.service.treatement.ITreatementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/treatement")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TreatementController {
    @Autowired
    private ITreatementService iTreatementService;

    // 7.2.1 Hiển thị List KhaiPN
    @GetMapping("/list")
    public ResponseEntity<Page<Treatement>> getListRealEstateNews(
            @RequestParam(defaultValue = "", value = "doctor") String doctor,
            @RequestParam(defaultValue = "", value = "kindOfDisease") String kindOfDisease,
            @RequestParam(defaultValue = "", value = "cage") String cage,
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 8, Sort.by("treatement_date").descending());
        Page< Treatement > iTreatementPage = iTreatementService.
                findAllTreatementsByFilter(doctor, kindOfDisease,cage, pageable);
        if (iTreatementPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iTreatementPage, HttpStatus.OK);
    }

    // 7.2.2 add treatement KhaiPN
    @PostMapping("/post")
    public ResponseEntity<List<FieldError>> saveRealEstateNews(@RequestBody @Valid TreatementDTO treatementDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        Treatement treatement = this.copyProperties(treatementDTO);
        treatement.setTreatementDate(LocalDateTime.now());
        Treatement newTreatement = iTreatementService.saveTreatement(treatement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Treatement copyProperties(TreatementDTO treatementDTO) {
        Treatement treatement = new Treatement();
        BeanUtils.copyProperties(treatementDTO, treatement);
        Individual individual = new Individual();
        individual.setId(treatementDTO.getIndividual().getId());
        treatement.setIndividual(individual);
        return treatement;
    }
}