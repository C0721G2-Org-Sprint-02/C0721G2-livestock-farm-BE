package com.project.livestockfarmbe.repository.employee;

import com.project.livestockfarmbe.dto.EmployeeServiceDTO;
import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    //    TranNN - List Employees
    @Query(value = "select * from employees where deleted = false", nativeQuery = true)
    Page<Employee> findAllEmployees(@Param("page") Pageable pageable);

    //    TranNN - List Employees
    @Query(value = "select e.id, e.address, e.date_of_birth as dateOfBirth, e.email, e.gender, e.id_card as idCard, e.image, e.name, e.phone_number as phoneNumber, e.app_user_id, e.deleted, username, r.roles_id as rolesId from employees e " +
            "join app_users a on e.app_user_id = a.id \n" +
            "join app_users_roles r on r.app_users_id = a.id \n" +
            "where `name` like :search and e.deleted = 0", nativeQuery = true,
            countQuery = "select count(*) from employees e " +
                    "join app_users a on e.app_user_id = a.id \n" +
                    "join app_users_roles r on r.app_users_id = a.id \n" +
                    "where `name` like :search and e.deleted = 0")
    Page<EmployeeServiceDTO> findEmployeeByName(@Param("search") String search, @Param("page") Pageable pageable);

    //    TranNN - List Employees
    @Query(value = "select e.id, e.address, e.date_of_birth as dateOfBirth, e.email, e.gender, e.id_card as idCard, e.image, e.name, e.phone_number as phoneNumber, e.app_user_id, e.deleted, username, r.roles_id as rolesId from employees e \n" +
            "join app_users a on e.app_user_id = a.id \n" +
            "join app_users_roles r on r.app_users_id = a.id \n" +
            "where e.deleted = 0 and r.roles_id like concat('%',trim(:roles_id),'%') " +
            "and (match (`name`, address, email, phone_number, id_card) against (:search) or username like concat('%',trim(:search),'%'))"
            , nativeQuery = true,
            countQuery = "select count(*) from employees e \n" +
                    "join app_users a on e.app_user_id = a.id \n" +
                    "join app_users_roles r on r.app_users_id = a.id \n" +
                    "where e.deleted = 0 and r.roles_id like concat('%',trim(:roles_id),'%') " +
                    "and (match (`name`, address, email, phone_number, id_card) against (:search) or username like concat('%',trim(:search),'%'))")
    Page<EmployeeServiceDTO> findBySearchFields(@Param("search") String search, @Param("roles_id") String roles_id, @Param("page") Pageable pageable);


    @Query(value = "SELECT * from employees e join app_users a on e.app_user_id = a.id where a.username =?1", nativeQuery = true)
    Employee findEmployeeByAppUser(String username);
}
