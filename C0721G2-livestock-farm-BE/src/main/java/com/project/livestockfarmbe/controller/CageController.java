package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.CageDTO;
import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.model.cage.TypeOfCage;
import com.project.livestockfarmbe.service.cage.impl.CageServiceImpl;
import com.project.livestockfarmbe.service.cage.impl.TypeOfCageServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/cages")
public class CageController {
    @Autowired
    CageServiceImpl cageService;

    @Autowired
    TypeOfCageServiceImpl typeOfCageService;

    @GetMapping(value = "/typeOfCage")
    public ResponseEntity<List<TypeOfCage>> showTypeOfCage() {
        List<TypeOfCage> typeOfCage = typeOfCageService.findAllTypeOfCage();
        if (typeOfCage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeOfCage, HttpStatus.OK);
    }

    // TungLe
    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveCage(@RequestBody @Valid CageDTO cageDTO, BindingResult bindingResult) {
        new CageDTO().validate(cageDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Cage cage = new Cage();
        Map<String, String> listErrors = new HashMap<>();
        //kiểm trả employee
//        if (!employeeService.checkEmployeeExist(cageDTO.getEmployeeId().getId())) {
//            System.out.println("tên employee không có ");
//            listErrors.put("employeeError", "Tên nhân viên không tồn tại.");
//        }

        //kiểm trả tên chuồng nuôi
        if (cageService.checkCageExist(cageDTO.getId())) {
            System.out.println("Tên chuồng nuôi đã tồn tại");
            listErrors.put("cageError", "Mã chuồng nuôi đã tồn tại.");
        }

//         set loại chuồng
        System.out.println("test chuồng nuôi");
        TypeOfCage typeOfCage = new TypeOfCage();
        typeOfCage.setId(cageDTO.getTypeOfCageDTO().getId());
        cage.setTypeOfCage(typeOfCage);


        if (!listErrors.isEmpty()) {
            System.out.println(listErrors.keySet());
            return ResponseEntity.badRequest().body(listErrors);
        }

        BeanUtils.copyProperties(cageDTO, cage);
        cageService.saveCage(cage);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findCageById(@PathVariable String id) {
        Optional<Cage> cage = cageService.findCageById(id);
        if (!cage.isPresent()) {
            System.out.println("Lỗi ");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cage.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Cage>> showListCage() {
        List<Cage> cages = (List<Cage>) cageService.findAllCage();
        if (cages.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cages, HttpStatus.OK);
    }

    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> updateCage(@RequestBody @Valid CageDTO cageDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("lỗi");
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        Cage cage = new Cage();
        BeanUtils.copyProperties(cageDTO, cage);
        System.out.println(cage.toString());
        cageService.saveCage(cage);
        return new ResponseEntity<>(cage, HttpStatus.OK);
    }
}
