package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.EmployeeServiceDTO;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.repository.employee.IEmployeeRepository;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;


    //    TranNN - Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable String id) {
        Optional<Employee> employeeOptional = this.iEmployeeService.findByIdOp(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    //    TranNN - List Employee
    @GetMapping("/list")
    public ResponseEntity<Page<EmployeeServiceDTO>> findAllEmployees(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer sort,
                                                            @RequestParam(defaultValue = "", value = "search") String search, @RequestParam(defaultValue = "", value = "role") String role) {
        Pageable pageable;
        if (role.equals("0")) {
            role = "";
        }
        switch (sort) {
            case 1:
                pageable = PageRequest.of(page, 4, Sort.by("name").ascending());
                break;
            case 2:
                pageable = PageRequest.of(page, 4, Sort.by("name").descending());
                break;
            case 3:
                pageable = PageRequest.of(page, 4, Sort.by("address").ascending());
                break;
            case 4:
                pageable = PageRequest.of(page, 4, Sort.by("address").descending());
                break;
            case 5:
                pageable = PageRequest.of(page, 4, Sort.by("date_of_birth").ascending());
                break;
            case 6:
                pageable = PageRequest.of(page, 4, Sort.by("date_of_birth").descending());
                break;
            default:
                pageable = PageRequest.of(page, 4, Sort.by("id").ascending());
        }
        Page<EmployeeServiceDTO> dtoPage;
        dtoPage = iEmployeeService.findByEmployeeByName(search,pageable);
        if (dtoPage.isEmpty()){
            dtoPage = iEmployeeService.employeeList(search, role, pageable);
        }
        if(dtoPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }
}
