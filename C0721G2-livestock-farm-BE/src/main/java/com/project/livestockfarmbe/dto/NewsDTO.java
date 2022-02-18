package com.project.livestockfarmbe.dto;

import com.project.livestockfarmbe.model.employee.Employee;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class NewsDTO {

    private String id;

    private Employee employee;
    @NotBlank(message = "Title không được bỏ trống")
    private String title;
    @NotBlank(message = "Content không được bỏ trống")
    private String content;
    private LocalDateTime postDate;
    private TypeOfNewsDTO typeOfNewsDTO;
    private String image;

    public NewsDTO() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public TypeOfNewsDTO getTypeOfNewsDTO() {
        return typeOfNewsDTO;
    }

    public void setTypeOfNewsDTO(TypeOfNewsDTO typeOfNewsDTO) {
        this.typeOfNewsDTO = typeOfNewsDTO;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id='" + id + '\'' +
                ", employee=" + employee +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                ", typeOfNewsDTO=" + typeOfNewsDTO +
                ", image='" + image + '\'' +
                '}';
    }
}
