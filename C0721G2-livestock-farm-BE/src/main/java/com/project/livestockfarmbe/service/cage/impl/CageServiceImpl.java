package com.project.livestockfarmbe.service.cage.impl;

import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.repository.cage.ICageRepository;
import com.project.livestockfarmbe.repository.employee.IEmployeeRepository;
import com.project.livestockfarmbe.service.cage.ICageService;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CageServiceImpl implements ICageService {
    @Autowired
    ICageRepository iCageRepository;

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Iterable<Cage> findAllCage() {
        return iCageRepository.findAll();
    }

    @Override
    public Optional<Cage> findCageById(String id) {
        return iCageRepository.findById(id);
    }

    @Override
    public Cage saveCage(Cage cage) {
        return iCageRepository.save(cage);
    }

    @Override
    public List<Employee> showListEmployee() {
        return (List<Employee>) iEmployeeRepository.findAll();
    }

    @Override
    public Boolean checkEmployee(String id) {
        return iEmployeeRepository.existsById(id);
    }


    @Override
    public Page<Cage> findAllCagePage(Pageable pageable) {
        return this.iCageRepository.listCages(pageable);
    }

    @Override
    public Page<Cage> findAllCagePageSearch(Pageable pageable, String search) {
        return this.iCageRepository.searchCageByEmployeeNameOrDayOponeOrTypeOfCage(pageable,search);
    }

    @Override
    public List<Cage> getCages() {
        return this.iCageRepository.findAll();
    }


    public Boolean checkCageExist(String id) {
        return iCageRepository.existsById(id);
    }


//    public Boolean checkEmployeeExist(String id) {
//        return iCageRepository.existsByEmployee(id);
//    }
}
