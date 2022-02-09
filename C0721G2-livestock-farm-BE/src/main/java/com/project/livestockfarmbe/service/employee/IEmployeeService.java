package com.project.livestockfarmbe.service.employee;

import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeService {

    //    TranNN - List Employees
    Page<Employee> findAllEmployee(Pageable pageable);

    Page<Employee> findAllEmployeeBySearchField(String name, String email,
                                                String address, String phone_number,
                                                String id_card, String username,
                                                Pageable pageable);
    Page<Employee> searchEmployee(String search, Pageable pageable);

    Page<Employee> findAllEmployeeByByRole(Integer roles_id, Pageable pageable);


    Optional<Employee> findByIdOp(String id);

    void deleteById(String id);
}
