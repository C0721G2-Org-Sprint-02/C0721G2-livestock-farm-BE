//package com.project.livestockfarmbe;
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
//public class CageController_editCage {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    // thành công
//    @Test
//    public void editCage_24() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        cageDTO.setId("CA-1225");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//        cageDTO.setQuantity(19);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 2);
//        cageDTO.setTypeOfCage(typeOfCageDTO);
//
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(cageDTO.getEmployee().getId());
//        cageDTO.setEmployee(employeeDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/edit")
//                .content(this.objectMapper.writeValueAsBytes(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void editCage_21() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        // sai format
//        cageDTO.setId("CA-122");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//        cageDTO.setQuantity(19);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 2);
//        cageDTO.setTypeOfCage(typeOfCageDTO);
//
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(cageDTO.getEmployee().getId());
//        cageDTO.setEmployee(employeeDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/edit")
//                .content(this.objectMapper.writeValueAsBytes(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void editCage_21_1() throws Exception {
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
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(cageDTO.getEmployee().getId());
//        cageDTO.setEmployee(employeeDTO);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/edit")
//                .content(this.objectMapper.writeValueAsBytes(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
//    @Test
//    public void editCage_19() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        // chứa null
//        cageDTO.setId(null);
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//
//        cageDTO.setQuantity(88);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 2);
//        cageDTO.setTypeOfCage(typeOfCageDTO);
//EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(cageDTO.getEmployee().getId());
//        cageDTO.setEmployee(employeeDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/edit")
//                .content(this.objectMapper.writeValueAsBytes(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(status().is4xxClientError());
//    }
    //    @Test
//    public void editCage_20() throws Exception {
//        CageDTO cageDTO = new CageDTO();
//        // chứa rỗng
//        cageDTO.setId("");
//        cageDTO.setOpenDate(LocalDate.parse("2000-10-10"));
//        cageDTO.setCloseDate(LocalDate.parse("2000-11-11"));
//
//        cageDTO.setQuantity(88);
//
//        TypeOfCageDTO typeOfCageDTO = new TypeOfCageDTO();
//        typeOfCageDTO.setId((long) 2);
//        cageDTO.setTypeOfCage(typeOfCageDTO);
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(cageDTO.getEmployee().getId());
//        cageDTO.setEmployee(employeeDTO);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/cages/edit")
//                .content(this.objectMapper.writeValueAsBytes(cageDTO))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print()).andExpect(statu   s().is4xxClientError());
//    }
//}