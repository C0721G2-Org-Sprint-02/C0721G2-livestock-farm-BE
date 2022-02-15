package com.project.livestockfarmbe.service.employee;


import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IEmployeeService {
    void saveEmployee(Employee employee);

    Optional<Employee> findById(String id);


    Employee getEmployeeByUsername(String username);

}
