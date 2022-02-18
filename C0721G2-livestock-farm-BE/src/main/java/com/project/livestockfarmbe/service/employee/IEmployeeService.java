package com.project.livestockfarmbe.service.employee;

import com.project.livestockfarmbe.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> showListEmployee();

    Boolean checkEmployee(String id);
}
