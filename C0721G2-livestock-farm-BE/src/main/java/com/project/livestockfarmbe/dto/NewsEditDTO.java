package com.project.livestockfarmbe.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class NewsEditDTO {
    private String id;
    @NotBlank(message = "Title không được bỏ trống")
    @Size(min = 20, max = 300, message = "Tiêu đề phải từ 20 đến 300 ký tự")
    private String title;
    @NotBlank(message = "Content không được bỏ trống")
    private String content;
    private LocalDateTime postDate;
    private TypeOfNewsDTO typeOfNewsDTO;
    private String image;


    public NewsEditDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
