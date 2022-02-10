package com.project.livestockfarmbe.service.employee.impl;

import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.repository.employee.IEmployeeRepository;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;


    //    TranNN - List Employees
    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return iEmployeeRepository.findAllEmployees(pageable);
    }

    @Override
    public Page<Employee> findAllEmployeeBySearchField(String name, String email, String address, String phone_number, String id_card, String username, Pageable pageable) {
//        return iEmployeeRepository.findAllEmployeeBySearchField(name,email,address,phone_number,id_card,username,pageable);
        return iEmployeeRepository.findAllEmployeeByUsername(username,pageable);
    }

    @Override
    public Page<Employee> searchEmployee(String search, Pageable pageable) {
        return iEmployeeRepository.searchEmployees(search,pageable);
    }

    @Override
    public Page<Employee> findAllEmployeeByByRole(Integer roles_id, Pageable pageable) {
        return iEmployeeRepository.findAllEmployeeByRole(roles_id,pageable);
    }

    @Override
    public Optional<Employee> findByIdOp(String id) {
        return this.iEmployeeRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        this.iEmployeeRepository.deleteById(id);
    }

}
