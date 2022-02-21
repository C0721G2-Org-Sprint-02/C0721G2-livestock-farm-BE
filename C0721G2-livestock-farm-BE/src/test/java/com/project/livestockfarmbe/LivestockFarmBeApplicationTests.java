package com.project.livestockfarmbe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.livestockfarmbe.dto.IndividualDTO;
import com.project.livestockfarmbe.model.cage.Cage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LivestockFarmBeApplicationTests {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;

    //trường hợp đúng
//    @Test
//    void individual_create() throws Exception {
//        IndividualDTO individualDTO = new IndividualDTO();
//        Cage cage = new Cage();
//        cage.setId("CA-0001");
//        individualDTO.setId("IN-0001");
//        individualDTO.setCage(cage);
//        LocalDate localDate = LocalDate.of(2022, Month.AUGUST, 12);
//        LocalDate localDate1 = LocalDate.of(2023, Month.DECEMBER, 15);
//        individualDTO.setDateIn(localDate);
//        individualDTO.setDateOut(localDate1);
//        individualDTO.setStatus(0);
//        individualDTO.setWeight(123.00);
//        this.mockMvc.
//                perform(MockMvcRequestBuilders.
//                        post("/api/individual/add").
//                        content(this.objectMapper.writeValueAsString(individualDTO)).
//                        contentType(MediaType.APPLICATION_JSON)).andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    //trường hợp đúng
//    @Test
//    void individual_edit() throws Exception {
//        IndividualDTO individualDTO = new IndividualDTO();
//        Cage cage = new Cage();
//        cage.setId("CA-0001");
//        individualDTO.setId("IN-0001");
//        individualDTO.setCage(cage);
//        LocalDate localDate = LocalDate.of(2022, Month.JUNE, 12);
//        LocalDate localDate1 = LocalDate.of(2023, Month.NOVEMBER, 23);
//        individualDTO.setDateIn(localDate);
//        individualDTO.setDateOut(localDate1);
//        individualDTO.setStatus(0);
//        individualDTO.setWeight(123.00);
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .patch("/api/individual/edit")
//                        .content(this.objectMapper.writeValueAsString(individualDTO))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    //trường hợp đúng
//    @Test
//    void individualfindById() throws Exception{
//        IndividualDTO individualDTO= new IndividualDTO();
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .get("/api/individual/id/IN-0012")
//                        .content(this.objectMapper.writeValueAsString(individualDTO))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//    //trường hợp không tìm thấy id
//    @Test
//    void individualfindById_not_found() throws Exception{
//        IndividualDTO individualDTO= new IndividualDTO();
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .get("/api/individual/id/IN-12")
//                        .content(this.objectMapper.writeValueAsString(individualDTO))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    //trường hợp sai weight
//    @Test
//    void individual_invalid_add()throws Exception{
//        IndividualDTO individualDTO = new IndividualDTO();
//        Cage cage = new Cage();
//        //wrong id
//        cage.setId("CA-001");
//        individualDTO.setCage(cage);
//        LocalDate localDate = LocalDate.of(2022, Month.AUGUST, 12);
//        LocalDate localDate1 = LocalDate.of(2023, Month.DECEMBER, 15);
//        individualDTO.setDateIn(localDate);
//        individualDTO.setDateOut(localDate1);
//        individualDTO.setStatus(0);
//        //overweight
//        individualDTO.setWeight(250.00);
//        this.mockMvc.
//                perform(MockMvcRequestBuilders.
//                        post("/api/individual/add").
//                        content(this.objectMapper.writeValueAsString(individualDTO)).
//                        contentType(MediaType.APPLICATION_JSON)).andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//    //weight >200
//    @Test
//    void individual_invalid_edit()throws Exception{
//        IndividualDTO individualDTO = new IndividualDTO();
//        Cage cage = new Cage();
//        //wrong id
//        cage.setId("CA-001");
//        individualDTO.setCage(cage);
//        LocalDate localDate = LocalDate.of(2022, Month.AUGUST, 12);
//        LocalDate localDate1 = LocalDate.of(2023, Month.DECEMBER, 15);
//        individualDTO.setDateIn(localDate);
//        individualDTO.setDateOut(localDate1);
//        individualDTO.setStatus(0);
//        //overweight
//        individualDTO.setWeight(200.00);
//        this.mockMvc.
//                perform(MockMvcRequestBuilders.
//                        post("/api/individual/add").
//                        content(this.objectMapper.writeValueAsString(individualDTO)).
//                        contentType(MediaType.APPLICATION_JSON)).andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
}