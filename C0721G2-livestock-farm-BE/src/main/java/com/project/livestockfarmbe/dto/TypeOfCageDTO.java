package com.project.livestockfarmbe.dto;

public class TypeOfCageDTO {
    private Long id;
    private String name;

    public TypeOfCageDTO() {
    }

    public TypeOfCageDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeOfCageDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeOfCageDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
