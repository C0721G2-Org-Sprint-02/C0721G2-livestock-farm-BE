//package com.project.livestockfarmbe.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class NewsController_deleteNews {
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    // Xóa cá thể tồn tại trong database
//    @Test
//    public void deleteNews_1() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/news/delete/{id}", "N-0003"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//
//    }
//
//    // Xóa cá thể không tồn tại trong database
//    @Test
//    public void deleteNews_2() throws Exception {
//
//        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/news/delete/{id}", "N-1234"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//
//    }
//
//    //    [id] = rỗng ("")
//    @Test
//    public void deleteNews_3() throws Exception {
//
//        this.mockMvc.perform
//                (MockMvcRequestBuilders
//                        .delete("/api/news/delete/{id}", ""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//
//    //    [id] = null
//    @Test
//    public void deleteNews_4() throws Exception {
//
//        this.mockMvc.perform
//                (MockMvcRequestBuilders
//                        .delete("/api/news/delete/{id}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//}
