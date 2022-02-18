//package com.project.livestockfarmbe;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.livestockfarmbe.dto.CageDTO;
//import com.project.livestockfarmbe.dto.EmployeeDTO;
//import com.project.livestockfarmbe.dto.TypeOfCageDTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDate;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CageController_createCage {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void createCage_18() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        cageDTO.setId("CA-1224");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//        cageDTO.setQuantity(19);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 1);
//        cageDTO.setTypeOfCageDTO(typeOfCageDTO);
//
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/create")
//                .content(this.objectMapper.writeValueAsString(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is2xxSuccessful());
//
//    }
//    @Test
//    public void createCage_15() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        // nhập id sai format
//        cageDTO.setId("CA-1");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//        cageDTO.setQuantity(19);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 1);
//        cageDTO.setTypeOfCageDTO(typeOfCageDTO);
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/create")
//                .content(this.objectMapper.writeValueAsString(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//
//    }
//    @Test
//    public void createCage_14() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        // đễ rỗng
//        cageDTO.setId("");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//        cageDTO.setQuantity(19);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 2);
//        cageDTO.setTypeOfCageDTO(typeOfCageDTO);
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/create")
//                .content(this.objectMapper.writeValueAsString(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//
//    }
//
//    @Test
//    public void createCage_13.1() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        cageDTO.setId("CA-2424");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//        // để null
//        cageDTO.setQuantity((Integer)null);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 2);
//        cageDTO.setTypeOfCageDTO(typeOfCageDTO);
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/create")
//                .content(this.objectMapper.writeValueAsString(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//
//    }

import org.junit.jupiter.api.Test;

//@Test
//public void createCage15() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        cageDTO.setId("CA-1224");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//
//        // chỉ cho nhập số
//        cageDTO.setQuantity("bảy");
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 2);
//        cageDTO.setTypeOfCage(typeOfCageDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/edit")
//        .content(this.objectMapper.writeValueAsBytes(cageDTO))
//        .contentType(MediaType.APPLICATION_JSON_VALUE))
//        .andDo(print()).andExpect(status().is4xxClientError());
//        }
//}
