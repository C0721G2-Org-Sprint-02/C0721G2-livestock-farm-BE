package com.project.livestockfarmbe.service.employee.impl;


import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.repository.employee.IEmployeeRepository;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return this.iEmployeeRepository.findEmployeeByAppUser(username);
    }
}
