package com.project.livestockfarmbe.dto;

import java.time.LocalDate;

public interface EmployeeServiceDTO {
    String getId();

    public String getName();

    public String getEmail();

    public String getPhone_number();

    public String getAddress();

    public LocalDate getDate_of_birth();

    public String getId_card();

    public Integer getGender();

    public String getUsername();

    public String getImage();

    public Integer getRoles_id();
}
