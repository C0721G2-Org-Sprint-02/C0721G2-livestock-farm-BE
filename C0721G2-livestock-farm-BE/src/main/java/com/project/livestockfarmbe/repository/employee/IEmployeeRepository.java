package com.project.livestockfarmbe.repository.employee;

import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "SELECT * from employees e join app_users a on e.app_user_id = a.id where a.username =?1", nativeQuery = true)
    Employee findEmployeeByAppUser(String username);
}
