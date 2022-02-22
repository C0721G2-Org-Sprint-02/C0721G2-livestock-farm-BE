package com.project.livestockfarmbe.dto;

import java.time.LocalDate;

public class SearchIndividualDTO {

    private String individualId;
    private String cageId;
    private LocalDate dateIn;
    private LocalDate dateOut;
    private Integer status;
    private String fieldSort;
    private String directionSort;
    private Integer page;

    public SearchIndividualDTO() {
    }

    public SearchIndividualDTO(String individualId, String cageId, LocalDate dateIn, LocalDate dateOut, Integer status, String fieldSort, String directionSort, Integer page) {
        this.individualId = individualId;
        this.cageId = cageId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.status = status;
        this.fieldSort = fieldSort;
        this.directionSort = directionSort;
        this.page = page;
    }

    public String getIndividualId() {
        return individualId;
    }

    public void setIndividualId(String individualId) {
        this.individualId = individualId;
    }

    public String getCageId() {
        return cageId;
    }

    public void setCageId(String cageId) {
        this.cageId = cageId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFieldSort() {
        return fieldSort;
    }

    public void setFieldSort(String fieldSort) {
        this.fieldSort = fieldSort;
    }

    public String getDirectionSort() {
        return directionSort;
    }

    public void setDirectionSort(String directionSort) {
        this.directionSort = directionSort;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
