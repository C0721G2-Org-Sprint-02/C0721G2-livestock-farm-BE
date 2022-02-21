//package com.project.livestockfarmbe.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.livestockfarmbe.dto.NewsDTO;
//import com.project.livestockfarmbe.dto.TypeOfNewsDTO;
//import com.project.livestockfarmbe.model.employee.Employee;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class NewsController_createNews {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    //Test title
//    @Test
//    public void createNews_title() throws Exception {
//
//        NewsDTO newsDTO = new NewsDTO();
//        newsDTO.setTitle(null);
//        newsDTO.setContent("Giật mình");
//        newsDTO.setImage("https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/ong-duong-tat-thang.jpg");
//        newsDTO.setPostDate(LocalDateTime.now());
//
//        TypeOfNewsDTO typeOfNewsDTO = new TypeOfNewsDTO();
//        typeOfNewsDTO.setId(1L);
//        newsDTO.setTypeOfNewsDTO(typeOfNewsDTO);
//
//        Employee employee = new Employee();
//        employee.setId(newsDTO.getEmployee().getId());
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/news/create")
//                        .content(this.objectMapper.writeValueAsString(newsDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    //Test content
//    @Test
//    public void createNews_content() throws Exception {
//
//        NewsDTO newsDTO = new NewsDTO();
//        newsDTO.setTitle("Lâm Đồng: Phát triển 900 trang trại vào cuối năm 2022");
//        newsDTO.setContent(null);
//        newsDTO.setImage("https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/ong-duong-tat-thang.jpg");
//        newsDTO.setPostDate(LocalDateTime.now());
//
//        TypeOfNewsDTO typeOfNewsDTO = new TypeOfNewsDTO();
//        typeOfNewsDTO.setId(1L);
//        newsDTO.setTypeOfNewsDTO(typeOfNewsDTO);
//
//        Employee employee = new Employee();
//        employee.setId(newsDTO.getEmployee().getId());
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/news/create")
//                        .content(this.objectMapper.writeValueAsString(newsDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//
//
//
//    //Thành công
//    @Test
//    public void createNews_18() throws Exception {
//
//        NewsDTO newsDTO = new NewsDTO();
//        newsDTO.setTitle("Giật tít");
//        newsDTO.setContent("Giật mình");
//        newsDTO.setImage("https://nguoichannuoi.vn/upload_images/images/tin-tuc-su-kien-chan-nuoi/ong-duong-tat-thang.jpg");
//        newsDTO.setPostDate(LocalDateTime.now());
//
//        TypeOfNewsDTO typeOfNewsDTO = new TypeOfNewsDTO();
//        typeOfNewsDTO.setId(1L);
//        newsDTO.setTypeOfNewsDTO(typeOfNewsDTO);
//
//        Employee employee = new Employee();
//        employee.setId(newsDTO.getEmployee().getId());
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/news/create")
//                        .content(this.objectMapper.writeValueAsString(newsDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
