package com.project.livestockfarmbe.repository.employee;

import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,String> {
}
