package com.project.livestockfarmbe.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.livestockfarmbe.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeController_editEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Test name
    @Test
    public void editEmployee_name_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0009");
        employeeDTO.setName(null);
        employeeDTO.setEmail("nguyenvana@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0009");
        employeeDTO.setName("Nguyễn Văn Anh");
        employeeDTO.setEmail("nguyenvana@gmail.com");
        employeeDTO.setPhoneNumber("0901234567");
        employeeDTO.setAddress("Da Nang");
        employeeDTO.setDateOfBirth(LocalDate.parse("1991-01-01"));
        employeeDTO.setIdCard("123456666");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Từ Phước Thịnh567856");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Từ");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_name_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Từ Phước Thịnhokokokokokokokok");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test email
    @Test
    public void editEmployee_email_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail(null);
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_email_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_email_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuonggmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_email_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("a@b.con");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_email_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhaknaksjdkjasbdkjt@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test phone
    @Test
    public void editEmployee_phone_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber(null);
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phone_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phone_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111abc");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phone_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("091111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_phone_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111123123");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test address
    @Test
    public void editEmployee_address_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress(null);
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_address_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_address_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("a");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_address_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng " +
                "NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng " +
                "NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng NgãiQuảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test Id card
    @Test
    public void editEmployee_idCard_13() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard(null);
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_idCard_14() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_idCard_15() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("197241502abc");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editEmployee_idCard_16() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("212324");
        employeeDTO.setGender(1);



        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editEmployee_idCard_17() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setEmail("nhatvuong@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Ngãi");
        employeeDTO.setDateOfBirth(LocalDate.parse("1997-04-12"));
        employeeDTO.setIdCard("212423058888");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Thành công
    @Test
    public void editEmployee_18() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId("NV-0003");
        employeeDTO.setName("Nguyễn Văn Doanh");
        employeeDTO.setEmail("doanhnguyen260898@gmail.com");
        employeeDTO.setPhoneNumber("0911111111");
        employeeDTO.setAddress("Quảng Nam");
        employeeDTO.setDateOfBirth(LocalDate.parse("1998-07-15"));
        employeeDTO.setIdCard("212423058");
        employeeDTO.setGender(1);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/edit")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
