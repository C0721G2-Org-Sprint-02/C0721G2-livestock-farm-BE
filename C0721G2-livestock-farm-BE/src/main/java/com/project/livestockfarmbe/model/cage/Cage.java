package com.project.livestockfarmbe.model.cage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.livestockfarmbe.customid.CustomIdGenerator;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.model.individual.Individual;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "cages")
@SQLDelete(sql = "UPDATE cages SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Cage {
    @Id
    private String id;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;
    @Column(name = "open_date", columnDefinition = "DATE")
    private LocalDate openDate;
    @Column(name = "close_date", columnDefinition = "DATE")
    private LocalDate closeDate;
    private int quantity;
    @ManyToOne(targetEntity = TypeOfCage.class)
    private TypeOfCage typeOfCage;
    private Boolean deleted = Boolean.FALSE;
    @OneToMany(mappedBy = "cage")
    @JsonBackReference
    private List<Individual> individualList;



    public Cage() {
    }

    @SuppressWarnings("squid:S00107")
    public Cage(String id, Employee employee, LocalDate openDate, LocalDate closeDate, int quantity, TypeOfCage typeOfCage, Boolean deleted, List<Individual> individualList) {
        this.id = id;
        this.employee = employee;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.quantity = quantity;
        this.typeOfCage = typeOfCage;
        this.deleted = deleted;
        this.individualList = individualList;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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



    public TypeOfCage getTypeOfCage() {
        return typeOfCage;
    }

    public void setTypeOfCage(TypeOfCage typeOfCage) {
        this.typeOfCage = typeOfCage;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<Individual> getIndividualList() {
        return individualList;
    }

    public void setIndividualList(List<Individual> individualList) {
        this.individualList = individualList;
    }

}
