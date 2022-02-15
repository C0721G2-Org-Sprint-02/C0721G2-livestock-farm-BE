package com.project.livestockfarmbe.dto;

import com.project.livestockfarmbe.model.cage.TypeOfCage;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.model.individual.Individual;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CageDTO implements Validator {

    @NotNull
    @Pattern(regexp = "^[C][A]-[0-9]{4}$")
    private String id;

    @NotNull
    private LocalDate openDate;
    @NotNull
    private LocalDate closeDate;
    @NotNull
//    @Pattern(regexp = "^[0-9]+$")
    private int quantity;
//    @NotNull
    private TypeOfCageDTO typeOfCageDTO;
//    @NotNull
    private Individual individual;
//    @NotNull
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

    public TypeOfCageDTO getTypeOfCageDTO() {
        return typeOfCageDTO;
    }

    public void setTypeOfCageDTO(TypeOfCageDTO typeOfCageDTO) {
        this.typeOfCageDTO = typeOfCageDTO;
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