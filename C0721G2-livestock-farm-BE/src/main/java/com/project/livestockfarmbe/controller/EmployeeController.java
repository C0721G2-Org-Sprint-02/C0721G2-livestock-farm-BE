package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.model.employee.Employee;
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


    //    TranNN - List Employees
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> showListEmployee(@RequestParam(defaultValue = "0") Integer page,
                                                           @RequestParam(defaultValue = "id") String sort,
                                                           @RequestParam(defaultValue = "0") Integer direction,
                                                           @RequestParam(defaultValue = "", value = "name") String name,
                                                           @RequestParam(defaultValue = "", value = "email") String email,
                                                           @RequestParam(defaultValue = "", value = "address") String address,
                                                           @RequestParam(defaultValue = "", value = "phone_number") String phone_number,
                                                           @RequestParam(defaultValue = "", value = "id_card") String id_card,
                                                           @RequestParam(defaultValue = "", value = "username") String username) {
        Pageable pageable;
        if (direction == 0) {
            pageable = PageRequest.of(page, 4, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page, 4, Sort.by(sort).descending());
        }
        Page<Employee> employeeList;
        if (name.equals("") && email.equals("") && address.equals("") && phone_number.equals("") && id_card.equals("") && username.equals("")) {
            employeeList = iEmployeeService.findAllEmployee(pageable);
        } else {
            employeeList = iEmployeeService.findAllEmployeeBySearchField
                    (name, email, address, phone_number, id_card, username, pageable);
            ;
        }
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    //    TranNN - List Employees
    @GetMapping(value = "/list-by-role")
    public ResponseEntity<Page<Employee>> showListEmployeeByRole(@RequestParam(defaultValue = "0") Integer page,
                                                                 @RequestParam(defaultValue = "id") String sort,
                                                                 @RequestParam(defaultValue = "0") Integer direction,
                                                                 @RequestParam(defaultValue = "0", value = "role") Integer role) {
        Pageable pageable;
        pageable = PageRequest.of(page, 4);
//        if (direction == 0) {
//            pageable = PageRequest.of(page, 4, Sort.by(sort).ascending());
//        } else {
//            pageable = PageRequest.of(page, 4, Sort.by(sort).descending());
//        }
        Page<Employee> employeeList;
        if (role == 0) {
            employeeList = iEmployeeService.findAllEmployee(pageable);
        } else {
            employeeList = iEmployeeService.findAllEmployeeByByRole(role, pageable);
        }
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Employee>> searchEmployee(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "id") String sort,
                                                         @RequestParam(defaultValue = "0") Integer direction, @RequestParam(defaultValue = "", value = "search") String search) {
        Pageable pageable;
        pageable = PageRequest.of(page, 4);
//        if (direction == 0) {
//            pageable = PageRequest.of(page, 4, Sort.by(sort).ascending());
//        } else {
//            pageable = PageRequest.of(page, 4, Sort.by(sort).descending());
//        }
        Page<Employee> employeeList;
        if (search.equals("")) {
            employeeList = iEmployeeService.findAllEmployee(pageable);
        } else {
            employeeList = iEmployeeService.searchEmployee(search, pageable);
        }
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    //    TranNN - Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable String id) {
        System.out.println(id);
        Optional<Employee> employeeOptional = this.iEmployeeService.findByIdOp(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }
}
