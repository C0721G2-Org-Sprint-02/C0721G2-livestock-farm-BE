package com.project.livestockfarmbe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;

    //Case chưa đăng nhập
    @Test
    public void authenticateUser_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(status().is4xxClientError());
    }
    //case đăng nhập thành công, với username = admin, password = 123
    @Test
    public void authenticateUser_2() throws Exception {
        String username = "admin";
        String password = "123";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.username").value("admin"))
                .andExpect(jsonPath("$.roles").value("ROLE_ADMIN"));


    }
    //Case sql injection
    @Test
    public void authenticateUser_3() throws Exception {
        String username = "'' OR '' = ''";
        String password = "123";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body))
                .andExpect(status().is4xxClientError());
    }

    //Case đăng nhập khi sai username
    @Test
    public void authenticateUser_4() throws Exception {
        String username = "wrongusername";
        String password = "123";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body))
                .andExpect(status().is4xxClientError());
    }


    //Case đăng nhập khi sai password
    @Test
    public void authenticateUser_5() throws Exception {
        String username = "admin";
//        this is wrong password
        String password = "4123532";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is4xxClientError())
        ;
    }
//  Case đăng nhập khi username=" ", password = " "
    @Test
    public void authenticateUser_6() throws Exception {
        String username = " ";
        String password = " ";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body))
                .andExpect(status().is4xxClientError());
    }

//   Case đăng nhập khi username = null, password = null
    @Test
    public void authenticateUser_7() throws Exception {
        String username = null;
        String password = null;

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body))
                .andExpect(status().is4xxClientError());
    }

}
