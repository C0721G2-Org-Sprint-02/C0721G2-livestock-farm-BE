package com.project.livestockfarmbe.dto;
import com.project.livestockfarmbe.model.cage.Cage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.*;
import java.time.LocalDate;

//thiện nhỏ//
public class IndividualDTO implements Validator {

    private String id;
    @NotNull(message = "Ngày vào chuồng không được để trống")
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private LocalDate dateIn;
    @NotNull(message = "Ngày ra chuồng không được để trống")
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private LocalDate dateOut;
    @NotNull(message = "Cân nặng không được trống")
    @Min(value = 2)
    @Max(value = 200)
    private Double weight;
    @NotNull(message = "Phải nhập ghi chú chi tiết của động vật")
    private Integer status;
    private Cage cage;

    public IndividualDTO(String id, LocalDate dateIn, LocalDate dateOut, Double weight, Integer status, Cage cage) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.weight = weight;
        this.status = status;
        this.cage = cage;
    }

    public IndividualDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
