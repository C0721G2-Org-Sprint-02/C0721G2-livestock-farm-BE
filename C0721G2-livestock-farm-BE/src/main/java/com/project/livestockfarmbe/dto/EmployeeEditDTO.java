package com.project.livestockfarmbe.dto;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class EmployeeEditDTO {
    private String id;
    @NotBlank(message = "Không được bỏ trống tên")
    @Pattern(regexp = "^[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+(\\s[a-zA-ZàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]+)*$", message = "Không được nhập số")
    @Size(min = 6, max = 40, message = "Tên phải từ 6 đến 40 ký tự")
    private String name;
    @NotBlank(message = "Không được bỏ trống email")
//    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$")
//    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
//    @Pattern(regexp = "^[a-z][a-z0-9_\.]{5,32}+@[a-z0-9]{2,}(\.[a-z0-9]{2,4}){1,2}$")
//    @Size(min = 8, max = 40, message = "Email phải từ 6 đến 40 ký tự")
    @Email
    private String email;
    @NotBlank(message = "Không được bỏ trống số điện thoại")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|89]|7[0|6-9]|8[0-6|89]|9[0-4|6-9])[0-9]{7}$", message = "Phải nhập đúng định dạng số điện thoại")
    private String phoneNumber;

    @NotBlank(message = "Không được bỏ trống địa chỉ")
    @Size(min = 6, max = 255, message = "Địa chỉ phải từ 6 đến 255 ký tự")
    private String address;

    @NotNull(message = "Không được để trống ngày sinh")
//    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Không đúng định dạng ngày sinh")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Không được để trống CMND")
    @Pattern(regexp = "^([0-9]{9})$|([0-9]{12})$",
            message = "Số CMND phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.")
    private String idCard;

    private Integer gender;

    private Long roleDTO;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(Long roleDTO) {
        this.roleDTO = roleDTO;
    }

    @Override
    public String toString() {
        return "EmployeeEditDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", idCard='" + idCard + '\'' +
                ", gender=" + gender +
                ", roleDTO=" + roleDTO +
                ", image='" + image + '\'' +
                '}';
    }
}
