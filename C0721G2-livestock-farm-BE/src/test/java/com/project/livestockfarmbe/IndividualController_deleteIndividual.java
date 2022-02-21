package com.project.livestockfarmbe;

import com.project.livestockfarmbe.controller.IndividualController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class IndividualController_deleteIndividual {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IndividualController individualController;

    // Xóa cá thể tồn tại trong database
    @Test
    public void deleteIndividual_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/individual/delete/{id}", "IN-1001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    // Xóa cá thể không tồn tại trong database
    @Test
    public void deleteIndividual_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/individual/delete/{id}", "IN-2001"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    //    [id] = rỗng ("")
    @Test
    public void deleteIndividual_3() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/individual/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    //    [id] = null
    @Test
    public void deleteIndividual_4() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/individual/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

}
