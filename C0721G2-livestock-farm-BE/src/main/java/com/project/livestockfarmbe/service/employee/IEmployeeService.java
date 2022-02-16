package com.project.livestockfarmbe.service.employee;

import com.project.livestockfarmbe.dto.EmployeeServiceDTO;
import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeService {

    //    TranNN - List Employees
    Page<EmployeeServiceDTO> employeeList (String search, String roles_id, Pageable pageable);

    Page<EmployeeServiceDTO> findByEmployeeByName (String search, Pageable pageable);

    Optional<Employee> findByIdOp(String id);

    void deleteById(String id);

    // DoanhNV
    Optional<Employee> findById(String id);

    void saveEmployee(Employee employee);
}
