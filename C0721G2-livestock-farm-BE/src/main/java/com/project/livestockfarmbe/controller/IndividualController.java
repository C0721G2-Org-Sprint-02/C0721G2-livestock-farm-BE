package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.IndividualDTO;
import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.service.individual.IIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/individual")
public class IndividualController {

    @Autowired
    IIndividualService iIndividualService;

    //thiện nhỏ//
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findIndividualbyId(@PathVariable("id") String id) {
        Optional<Individual> individual = iIndividualService.findIndividualWithId(id);
        if (!individual.isPresent()) {
            String message = "Không tồn tại";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(individual.get(), HttpStatus.OK);
    }

    //thiện nhỏ//
    @PostMapping("/add")
    public ResponseEntity<Object> createNewindividual(@RequestBody @Valid IndividualDTO individualDTO,
                                                      BindingResult bindingResult) {
        new IndividualDTO().validate(individualDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        iIndividualService.save(individualDTO);
        String message = "Dữ liệu mới đã được tạo";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    //thiện nhỏ//
    @PatchMapping("/edit")
    public ResponseEntity<Object> editOldindividual(@RequestBody @Valid IndividualDTO individualDTO,
                                                    BindingResult bindingResult) {
        new IndividualDTO().validate(individualDTO, bindingResult);
        if (findIndividualbyId(individualDTO.getId()) != null) {
                if (bindingResult.hasErrors()) {
                    return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
                }
            Object individual = iIndividualService.save(individualDTO);
            return new ResponseEntity<>(individual, HttpStatus.OK);
        }
        String message = "id not exist";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Individual> deleteIndividual(@PathVariable String id){
        Individual individual = this.iIndividualService.findIndividualById(id);

        if (individual == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iIndividualService.deleteIndividual(individual);
        return new ResponseEntity<>(individual, HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Individual> findIndividualById(@PathVariable String id){
        Individual individual = this.iIndividualService.findIndividualById(id);

        if (individual == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(individual, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Individual>> showIndividualList(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "") String individualId,
            @RequestParam(defaultValue = "") String cageId,
            @RequestParam(defaultValue = "") String dateIn,
            @RequestParam(defaultValue = "") String dateOut,
            @RequestParam(defaultValue = "") String status){

        int size = 5;
        Page<Individual> individualPage = this.iIndividualService.findAllIndividual(page,size,sortField,
                sortDirection,individualId,cageId,dateIn,dateOut,status);

        if (individualPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(individualPage, HttpStatus.OK);

    }
}


