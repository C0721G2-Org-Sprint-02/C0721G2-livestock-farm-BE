package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.CageDTO;
import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.model.cage.TypeOfCage;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.service.cage.impl.CageServiceImpl;
import com.project.livestockfarmbe.service.cage.impl.TypeOfCageServiceImpl;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import com.project.livestockfarmbe.service.employee.impl.EmployeeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cageListSearch, HttpStatus.OK);
    }


    @GetMapping(value = "/employee")
    public ResponseEntity<List<Employee>> showEmployee() {
        List<Employee> employees = cageService.showListEmployee();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


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
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Cage cage = new Cage();


        Map<String, String> listErrors = new HashMap<>();
        //ki???m tra employee
        if (!cageService.checkEmployee(cageDTO.getEmployee().getId())) {
            System.out.println("t??n employee kh??ng c?? ");
            listErrors.put("employeeError", "T??n nh??n vi??n kh??ng t???n t???i.");
        }


        //ki???m tr??? t??n chu???ng nu??i
        if (cageService.checkCageExist(cageDTO.getId())) {
            System.out.println("T??n chu???ng nu??i ???? t???n t???i");
            listErrors.put("cageError", "M?? chu???ng nu??i ???? t???n t???i.");
        }

//         set lo???i chu???ng
        System.out.println("test chu???ng nu??i");
        TypeOfCage typeOfCage = new TypeOfCage();
        typeOfCage.setId(cageDTO.getTypeOfCage().getId());
        cage.setTypeOfCage(typeOfCage);

        // set nh??n vi??n
        Employee employee = new Employee();
        System.out.println(cageDTO.getEmployee().getId());
        employee.setId(cageDTO.getEmployee().getId());
        cage.setEmployee(employee);





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
            System.out.println("L???i ");
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

    // T??ng edit
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> updateCage(@RequestBody @Valid CageDTO cageDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("l???i");
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        Cage cage = new Cage();
        Map<String, String> listErrors = new HashMap<>();


        // set lo???i chu???ng
        System.out.println("test chu???ng nu??i");
        TypeOfCage typeOfCage = new TypeOfCage();
        typeOfCage.setId(cageDTO.getTypeOfCage().getId());
        cage.setTypeOfCage(typeOfCage);

        // set nh??n vi??n
        System.out.println("nh??n vi??n");
        Employee employee = new Employee();
        employee.setId(cageDTO.getEmployee().getId());
        cage.setEmployee(employee);


        //ki???m tra employee
        if (!cageService.checkEmployee(cage.getEmployee().getId())) {
            System.out.println("t??n employee kh??ng c?? ");
            listErrors.put("employeeError", "T??n nh??n vi??n kh??ng t???n t???i.");
        }


        if (!listErrors.isEmpty()) {
            System.out.println(listErrors.keySet());
            return ResponseEntity.badRequest().body(listErrors);
        }


        BeanUtils.copyProperties(cageDTO, cage);
        System.out.println(cage.toString());
        cageService.saveCage(cage);
        return new ResponseEntity<>(cage, HttpStatus.OK);
    }
    //cai nay cua thien
    @GetMapping(value = "/listCage")
    public ResponseEntity<List<Cage>> getCages() {
        List<Cage> cagesList = cageService.getCages();
        if(cagesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cagesList,HttpStatus.OK);
    }
}
