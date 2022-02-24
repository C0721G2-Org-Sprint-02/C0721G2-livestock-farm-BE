package com.project.livestockfarmbe.service.cage;

import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICageService {
    // Dùng chung
    Iterable<Cage> findAllCage();

    // Dùng chung
    Optional<Cage> findCageById(String id);

    //Tùng
    Cage saveCage(Cage cage);

    List<Employee> showListEmployee();

    Boolean checkEmployee(String id);

    Page<Cage> findAllCagePage(Pageable pageable);
    Page<Cage> findAllCagePageSearch(Pageable pageable, String search);

    List<Cage> getCages();
}
