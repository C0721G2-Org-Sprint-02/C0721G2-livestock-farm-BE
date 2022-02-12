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
@RequestMapping("/TestAPI")
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
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Object> editOldindividual(@RequestBody @Valid IndividualDTO individualDTO,
                                                    BindingResult bindingResult, @PathVariable("id") String id) {
        new IndividualDTO().validate(individualDTO, bindingResult);
     //Id trên link và id gửi xuống đang không bằng nhau, vì lí do nào đó/
        System.out.println(individualDTO.getId().equals(iIndividualService.findIndividualById(id)));
        if (individualDTO.getId().equals(iIndividualService.findIndividualById(id))) {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<Object>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
            }
            Object individual = iIndividualService.save(individualDTO);
            return new ResponseEntity<>(individual, HttpStatus.OK);
        }
        String message = "id nhập và id đường dẫn không dúng";
        return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
    }
}
