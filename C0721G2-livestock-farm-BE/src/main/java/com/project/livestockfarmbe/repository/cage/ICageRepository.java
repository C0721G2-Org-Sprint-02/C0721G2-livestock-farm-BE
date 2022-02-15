package com.project.livestockfarmbe.repository.cage;

import com.project.livestockfarmbe.model.cage.Cage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICageRepository extends JpaRepository<Cage, String> {

    @Query(value= "select c.id, e.id as employee_id, e.`name`, c.open_date, c.close_date, t.`name`,c.quantily , " +
            "c.deleted , c.type_of_cage_id as type_of_cage_id from cages c \n" +
            "join employees e on c.employee_id = e.id \n" +
            "join type_of_cage t on c.type_of_cage_id = t.id \n" +
            "where e.`name` like concat(\"%\", :search, \"%\") or c.open_date like concat(\"%\", :search, \"%\") " +
            "or t.`name` like concat(\"%\", :search, \"%\")", nativeQuery = true,
            countQuery = "select count(*) from cages c \n" +
                    "join employees e on c.employee_id = e.id \n" +
                    "join type_of_cage t on c.type_of_cage_id = t.id \n" +
                    "where e.`name` like concat(\"%\", :search, \"%\") or c.open_date like concat(\"%\", :search, \"%\")" +
                    " or t.`name` like concat(\"%\", :search, \"%\") ;")
    Page<Cage> searchCageByEmployeeNameOrDayOponeOrTypeOfCage(Pageable pageable, @Param("search") String  search);

    @Query(value= "select c.id, c.employee_id, e.id, e.`name`, c.open_date,c.close_date, c.quantily, c.type_of_cage_id," +
            " c.deleted from cages c join employees e on c.employee_id = e.id", nativeQuery = true,
    countQuery = "select count(*) from cages c join employees e on c.employee_id = e.id")
    Page<Cage> listCages(Pageable pageable);
}
