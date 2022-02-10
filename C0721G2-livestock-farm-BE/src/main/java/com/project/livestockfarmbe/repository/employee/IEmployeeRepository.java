package com.project.livestockfarmbe.repository.employee;

import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "select * from employees where deleted = false", nativeQuery = true)
    Page<Employee> findAllEmployees(@Param("page") Pageable pageable);

    //    TranNN - List Employees
    @Query(value = "select * from employees e\n" +
            " join app_users a on e.app_user_id = a.id" +
            " where `name` like concat('%',trim(:name),'%')\n" +
            " and email like concat('%',trim(:email),'%')\n" +
            " and address like concat('%',trim(:address),'%')\n" +
            " and phone_number like concat('%',trim(:phone_number),'%')\n" +
            " and id_card like concat('%',trim(:id_card),'%')\n" +
            " and username like concat('%',trim(:username),'%') " +
            " and e.deleted = false and a.deleted = false",
            nativeQuery = true
    )
    Page<Employee> findAllEmployeeBySearchField(@Param("name") String name,
                                                @Param("email") String email,
                                                @Param("address") String address,
                                                @Param("phone_number") String phone_number,
                                                @Param("id_card") String id_card,
                                                @Param("username") String username,
                                                @Param("page") Pageable pageable);


    @Query(value = "select *  from employees \n" +
            "where match (`name`, address, email, phone_number, id_card) against (:search) ", nativeQuery = true)
    Page<Employee> searchEmployees(@Param("search") String search, @Param("page") Pageable pageable);

    @Query(value = "select * from employees e\n" +
            " join app_users a on e.app_user_id = a.id" +
            " where username like concat('%',trim(:username),'%') and e.deleted = false and a.deleted = false",
            nativeQuery = true)
    Page<Employee> findAllEmployeeByUsername(@Param("username") String username,
                                           @Param("page") Pageable pageable);


    //    TranNN - List Employees
    @Query(value = "select * from employees e\n" +
            " join app_users_roles r on e.app_user_id = r.app_users_id \n" +
            " where roles_id  like concat('%',trim(:roles_id),'%') and e.deleted = false",
            nativeQuery = true
    )
    Page<Employee> findAllEmployeeByRole(@Param("roles_id") Integer roles_id, @Param("page") Pageable pageable);

}
