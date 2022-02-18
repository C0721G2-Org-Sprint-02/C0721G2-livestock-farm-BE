package com.project.livestockfarmbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsController_getNewsId {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoNews_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/news/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoNews_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/news/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoEmployee_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/news/{id}", "NV-010"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoEmployee_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/edit/{id}", "N-0009"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value("N-0009"))
                .andExpect(jsonPath("$.content").value("Từ điều kiện địa lý, Hà Nội có tiềm năng, lợi thế phát triển chăn nuôi bò thịt, bò sữa. Thời gian qua, nhiều địa phương trên địa bàn thành phố đã đưa giống bò mới vào sản xuất, đạt hiệu quả cao. Tuy nhiên, để chăn nuôi bò phát triển bền vững, các địa phương, đơn vị còn nhiều việc phải làm.\n" +
                        " Bà Trương Thị Kiểm ở xã Vân Hòa (huyện Ba Vì) cho biết, gia đình bà đang nuôi 6 con bò sữa, bán được sữa với giá bình quân 11.000 - 14.000 đồng/lít. Chăn nuôi bò sữa vất vả nhưng ổn định, không biến động như chăn nuôi lợn, gà... Còn hộ ông Đặng Đình Hậu ở xã Lam Điền (huyện Chương Mỹ) đang nuôi tổng đàn khoảng 100 con bò thịt giống BBB. Đây là giống bò cho năng suất, chất lượng cao, doanh thu đạt khoảng 700 triệu đồng/năm, trừ các khoản chi phí, lãi 350 triệu đồng/năm. “Nếu như trước đây, bò thịt truyền thống cho lãi 5 - 6 triệu đồng/năm thì các giống bò lai cho lãi 8 - 10 triệu đồng/con”, ông Hậu chia sẻ."))
                .andExpect(jsonPath("$.image").value("https://nguoichannuoi.vn/upload_images/images/nha-nong-lam-giau/nuoi-bo-sua-ba-vi.jpg"))
                .andExpect(jsonPath("$.postDate").value("2022-02-16 23:26:27.041000"))
                .andExpect(jsonPath("$.title").value("Hà Nội: Sài gòn"))
                .andExpect(jsonPath("$.employee").value("NV-1006"))
                .andExpect(jsonPath("$.typeOfNews").value(2))
                .andExpect(jsonPath("$.deleted").value(Boolean.FALSE));
    }
}
