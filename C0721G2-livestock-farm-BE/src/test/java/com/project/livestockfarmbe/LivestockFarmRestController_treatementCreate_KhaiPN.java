package com.project.livestockfarmbe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.livestockfarmbe.dto.TreatementDTO;
import com.project.livestockfarmbe.model.individual.Individual;
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
public class LivestockFarmRestController_treatementCreate_KhaiPN {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Test create thành công
    @Test
    public void createTreatement_1() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
        ;
    }

    //Test create thất bại: thêm vào mã cá thể(individual) không tồn tại trong list individual(id: "IN-asds")
    @Test
    public void createTreatement_2() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-asds");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }
    //Test create thất bại: doctor = blank)
    @Test
    public void createTreatement_3() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: doctor = blank
    @Test
    public void createTreatement_4() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: doctor = "123AN Nguyen" (tên bác sĩ không được có số)
    @Test
    public void createTreatement_5() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("123AN Nguyen");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: doctor = "A" (tên bác sĩ chỉ có 1 ký tự)
    @Test
    public void createTreatement_6() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("A");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: medicine = blank
    @Test
    public void createTreatement_7() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: medicine = "01234567890123456789012345678901234567890123" (tên loại thuốc quá 40 ký tự)
    @Test
    public void createTreatement_8() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("01234567890123456789012345678901234567890123");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: kindOfDisease = blank
    @Test
    public void createTreatement_9() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: kindOfDisease = "01234567890123456789012345678901234567890123456789
    // 01234567890123456789012345678901234567890123456789
    // 01234567890123456789012345678901234567890123456789
    // 01234567890123456789012345678901234567890123456789
    // 01234567890123456789012345678901234567890123456789
    // 0123456789012345678901" (tên loại thuốc quá 255 ký tự)
    @Test
    public void createTreatement_10() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("01234567890123456789012345678901234567890123456789\n" +
                "01234567890123456789012345678901234567890123456789\n" +
                "01234567890123456789012345678901234567890123456789\n" +
                "01234567890123456789012345678901234567890123456789\n" +
                "01234567890123456789012345678901234567890123456789\n" +
                "0123456789012345678901");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(5);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: quantily = -1 (số lượng phải là số dương)
    @Test
    public void createTreatement_11() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(-1);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

    //Test create thất bại: quantily = 101 (số lượng phải là số dương < 100)
    @Test
    public void createTreatement_12() throws Exception {
        TreatementDTO treatementDTO = new TreatementDTO();
        treatementDTO.setDoctor("Phan Ngọc Khải");
        treatementDTO.setKindOfDisease("Phòng tai xanh");
        treatementDTO.setMedicine("TX M2");
        treatementDTO.setNote("Cho uống lại sau 8 tháng");
        treatementDTO.setQuantily(101);
        Individual individual = new Individual();
        individual.setId("IN-1002");
        treatementDTO.setIndividual(individual);
        this.mockMvc.perform((MockMvcRequestBuilders
                .post("/api/treatement/post"))
                .content(this.objectMapper.writeValueAsString(treatementDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError())
        ;
    }

}
