package com.project.livestockfarmbe.service.employee.impl;

import com.project.livestockfarmbe.dto.EmployeeServiceDTO;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.model.news.TypeOfNews;
import com.project.livestockfarmbe.repository.employee.IEmployeeRepository;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    //    TranNN - List Employees
    @Override
    public Page<EmployeeServiceDTO> employeeList(String search, String roles_id, Pageable pageable) {
        return iEmployeeRepository.findBySearchFields(search,roles_id,pageable);
    }

    @Override
    public Page<EmployeeServiceDTO> findByEmployeeByName(String search, Pageable pageable) {
        return iEmployeeRepository.findEmployeeByName(search,pageable);
    }


    @Override
    public Optional<Employee> findByIdOp(String id) {
        return this.iEmployeeRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        this.iEmployeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return this.iEmployeeRepository.findEmployeeByAppUser(username);
    }

    // DoanhNV
    @Override
    public Optional<Employee> findById(String id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void saveEmployeeDTO(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return this.iEmployeeRepository.findAll();
    }
}
