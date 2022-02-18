package com.project.livestockfarmbe.service.employee.impl;

import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.repository.employee.IEmployeeRepository;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    public List<Employee> showListEmployee() {
        return (List<Employee>) iEmployeeRepository.findAll();
    }

    @Override
    public Boolean checkEmployee(String id) {
        return iEmployeeRepository.existsById(id);
    }
}
