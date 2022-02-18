package com.project.livestockfarmbe.dto;

public class TypeOfNewsDTO {
    private Long id;
    private String name;

    public TypeOfNewsDTO() {
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
        return "TypeOfNewsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
