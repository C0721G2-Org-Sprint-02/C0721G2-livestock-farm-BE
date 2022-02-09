package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.CageDTO;
import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.service.cage.impl.CageServiceImpl;
import com.project.livestockfarmbe.service.cage.impl.TypeOfCageServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/cages")
public class CageController {
    @Autowired
    CageServiceImpl cageService;

    @Autowired
    TypeOfCageServiceImpl typeOfCageService;

// TungLe
    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveCage(@RequestBody @Valid CageDTO cageDTO, BindingResult bindingResult) {
        new CageDTO().validate(cageDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Cage cage = new Cage();
        BeanUtils.copyProperties(cageDTO, cage);
        cageService.saveCage(cage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cage> findCageById(@PathVariable String id) {
        Optional<Cage> cages = cageService.findCageById(id);
        if (!cages.isPresent()) {
            System.out.println("123123");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cages.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Cage>> showListCage() {
        List<Cage> cages = (List<Cage>) cageService.findAllCage();
        if (cages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cages, HttpStatus.OK);
    }
}
