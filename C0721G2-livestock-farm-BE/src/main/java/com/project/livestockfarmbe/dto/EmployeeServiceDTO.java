package com.project.livestockfarmbe.dto;

import java.time.LocalDate;

public interface EmployeeServiceDTO {
    String getId();

    public String getName();

    public String getEmail();

    public String getPhoneNumber();

    public String getAddress();

    public LocalDate getDateOfBirth();

    public String getIdCard();

    public Integer getGender();

    public String getUsername();

    public String getImage();

    public Integer getRolesId();
}
