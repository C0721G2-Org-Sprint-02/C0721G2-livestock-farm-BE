package com.project.livestockfarmbe.dto;

import com.project.livestockfarmbe.model.cage.TypeOfCage;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.model.individual.Individual;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class CageDTO implements Validator {
    private String id;

    private LocalDate openDate;
    private LocalDate closeDate;
    private int quantity;
    private TypeOfCage typeOfCage;
    private Individual individual;
    private Employee employeeId;

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public CageDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TypeOfCage getTypeOfCage() {
        return typeOfCage;
    }

    public void setTypeOfCage(TypeOfCage typeOfCage) {
        this.typeOfCage = typeOfCage;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
//    private String id;
//    @ManyToOne(targetEntity = Employee.class)
//    private Employee employee;
//    @Column(name = "open_date", columnDefinition = "DATE")
//    private LocalDate openDate;
//    @Column(name = "close_date", columnDefinition = "DATE")
//    private LocalDate closeDate;
//    private int quantity;
//    @ManyToOne(targetEntity = TypeOfCage.class)
//    private TypeOfCage typeOfCage;
//
//    private Boolean deleted = Boolean.FALSE;
//    @OneToMany(mappedBy = "cage")
//    @JsonBackReference
//    private List<Individual> individualList;