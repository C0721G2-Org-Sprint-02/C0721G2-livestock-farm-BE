package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.IndividualDTO;
import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.service.individual.IIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findIndividualbyId(@PathVariable("id") String id) {
        Optional<Individual> individual = iIndividualService.findIndividualById(id);
        if (!iIndividualService.findIndividualById(id).isPresent()) {
            String message = "Không tồn tại";
            return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(individual.get(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> createNewindividual(@RequestBody @Valid IndividualDTO individualDTO,
                                                      BindingResult bindingResult) {
        new IndividualDTO().validate(individualDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Object>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        iIndividualService.save(individualDTO);
        String message ="Dữ liệu mới đã được tạo";
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Object> editOldindividual(@RequestBody @Valid IndividualDTO individualDTO,
                                                    BindingResult bindingResult) {
        new IndividualDTO().validate(individualDTO, bindingResult);
        if (findIndividualbyId(individualDTO.getId())!=null) {
            if (individualDTO.getId().equals(iIndividualService.findIndividualById(individualDTO.getId()))) {
                if (bindingResult.hasErrors()) {
                    return new ResponseEntity<Object>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
                }
            }
            Object individual = iIndividualService.save(individualDTO);
            return new ResponseEntity<>(individual, HttpStatus.OK);
        }
        String message = "id not exist";
        return new ResponseEntity<Object>(message,HttpStatus.NOT_FOUND);
    }
}


