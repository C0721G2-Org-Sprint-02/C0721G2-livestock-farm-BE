package com.project.livestockfarmbe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.livestockfarmbe.model.buyIndividual.BuyIndividual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LiveStockFarm_CreateBuyIndividual {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createRealEstate_test1() throws Exception {
        BuyIndividual buyIndividual = new BuyIndividual();
        buyIndividual.setName("Nguyen Van Nghia");
        buyIndividual.setEmail("nghia@gmail.com");
        buyIndividual.setPhoneNumber("0999999916");
        buyIndividual.setAddress("Đà Nẵng");
        buyIndividual.setContent("Tôi cần mua 10 con bò");

        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/buy_individual/create"))
                .content(this.objectMapper.writeValueAsString(buyIndividual))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;
    }
    @Test
    public void createRealEstate_test2() throws Exception {
        BuyIndividual buyIndividual = new BuyIndividual();
        buyIndividual.setName("Nguyen Van Bon");
        buyIndividual.setEmail("b@gmail.com");
        buyIndividual.setPhoneNumber("0999999982");
        buyIndividual.setAddress("Đà Nẵng");
        buyIndividual.setContent("Tôi cần mua 10 con heo");

        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/buy_individual/create"))
                .content(this.objectMapper.writeValueAsString(buyIndividual))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;
    }
}
