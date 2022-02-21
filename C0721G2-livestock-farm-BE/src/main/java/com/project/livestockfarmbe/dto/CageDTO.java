package com.project.livestockfarmbe.dto;

import com.project.livestockfarmbe.model.individual.Individual;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CageDTO implements Validator {

    @NotEmpty
    @Pattern(regexp = "^[C][A]-[0-9]{4}$")
    private String id;

    // để notEmpty sẽ bị lỗi
    @NotBlank
    private LocalDate openDate;
    @NotBlank
    private LocalDate closeDate;
    @NotNull
//    @Pattern(regexp = "^[0-9]+$")
    private int quantity;
    //    @NotEmpty
    private TypeOfCageDTO typeOfCage;
    //    @NotEmpty
    private Individual individual;

    private EmployeeDTO employee;


    public CageDTO() {
    }

    public TypeOfCageDTO getTypeOfCage() {
        return typeOfCage;
    }

    public void setTypeOfCage(TypeOfCageDTO typeOfCage) {
        this.typeOfCage = typeOfCage;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
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

    public static void main(String[] args) {

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