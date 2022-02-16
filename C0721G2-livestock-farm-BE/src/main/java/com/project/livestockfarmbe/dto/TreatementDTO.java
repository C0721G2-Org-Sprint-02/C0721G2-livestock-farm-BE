package com.project.livestockfarmbe.dto;

import com.project.livestockfarmbe.model.individual.Individual;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

public class TreatementDTO {
    private String id;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([^0-9]{2,})$", message = "Tên không được có số và từ 2 kí tự trở lên")
    private String doctor;

    @NotBlank(message = "Không được để trống")
    @Size(max = 40, message = "max 40")
    private String medicine;

    @NotBlank(message = "Không được để trống")
    @Size(max = 255, message = "max 255")
    private String kindOfDisease;

    private String note;

    @Min(value = 1, message = "Phải là số dương(1-100)")
    @Max(value = 100, message = "Phải là số dương(1-100)")
    @NotNull(message = "NotNull")
    private int quantily;

    @ManyToOne(targetEntity = Individual.class)
    private Individual individual;

    public TreatementDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getKindOfDisease() {
        return kindOfDisease;
    }

    public void setKindOfDisease(String kindOfDisease) {
        this.kindOfDisease = kindOfDisease;
    }

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
