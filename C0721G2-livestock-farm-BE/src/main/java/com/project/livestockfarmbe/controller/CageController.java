package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.service.cage.ICageService;
import com.project.livestockfarmbe.service.cage.ITypeOfCageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/cage")
@CrossOrigin("http://localhost:4200")
public class CageController {
  
    @Qualifier("typeOfCageServiceImpl")
    @Autowired
    ITypeOfCageService typeOfCageService;

    @Qualifier("cageServiceImpl")
    @Autowired
    ICageService cageService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Cage>> showCages(@PageableDefault(value = 5) Pageable pageable) {
        Page<Cage> cagesList = cageService.findAllCagePage(pageable);
        if(cagesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cagesList,HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Cage>> searchEmployee(@PageableDefault(value = 10) Pageable pageable,
                                                         @RequestParam(defaultValue = "") String search
    ) {
        Page<Cage> cageListSearch = cageService.findAllCagePageSearch(pageable, search);
        if (cageListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cageListSearch, HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Cage> getEmployee(@PathVariable String id) {
        Optional<Cage> cage = cageService.findByIdOp(id);

        if (!cage.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cage.get(), HttpStatus.OK);
    }

}
