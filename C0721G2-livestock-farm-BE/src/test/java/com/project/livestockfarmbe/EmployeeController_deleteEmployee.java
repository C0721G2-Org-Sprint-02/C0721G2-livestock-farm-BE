package com.project.livestockfarmbe;

import com.project.livestockfarmbe.controller.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class EmployeeController_deleteEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeController employeeController;

    // Xóa cá nhân viên  tại trong database
    @Test
    public void deleteEmployee_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/employee/delete/{id}", "NV-1001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    // Xóa cá thể không tồn tại trong database
    @Test
    public void deleteEmployee_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/employee/delete/{id}", "IN-2001"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    //    [id] = rỗng ("")
    @Test
    public void deleteEmployee_3() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/employee/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    //    [id] = null
    @Test
    public void deleteEmployee_4() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/employee/delete/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


}
