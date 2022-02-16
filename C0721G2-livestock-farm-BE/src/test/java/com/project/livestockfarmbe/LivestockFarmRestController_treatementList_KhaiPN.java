package com.project.livestockfarmbe;

import com.project.livestockfarmbe.controller.TreatementController;
import com.project.livestockfarmbe.model.treatement.Treatement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LivestockFarmRestController_treatementList_KhaiPN {
    @Autowired
    private TreatementController treatementController;
    @Autowired
    private MockMvc mockMvc;

    //Test chức năng list case 1 => 3
    //  Trường hợp có dữ liệu
    @Test
    public void getTreatementList_1() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //  Không có dữ liệu
    @Test
    public void getTreatementList_2() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("", "", "", 10);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }


    //   Test dữ liệu chính xác: người cuối cùng(thứ 8) của trang đầu tiên (trang 0)
    @Test
    public void getTreatementList_3() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(21, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("TR-1010",
                responseEntity.getBody().getContent().get(7).getId());
        Assertions.assertEquals("Ngô Thừa Ân",
                responseEntity.getBody().getContent().get(7).getDoctor());
        Assertions.assertEquals("NOVMAE E1",
                responseEntity.getBody().getContent().get(7).getMedicine());
        Assertions.assertEquals("Chữa huyết trùng lợn",
                responseEntity.getBody().getContent().get(7).getKindOfDisease());
        Assertions.assertEquals(2,
                responseEntity.getBody().getContent().get(7).getQuantily());
        Assertions.assertEquals("Cho uống lại sau 1 năm",
                responseEntity.getBody().getContent().get(7).getNote());
        Assertions.assertEquals(false,
                responseEntity.getBody().getContent().get(7).getDeleted());
        Assertions.assertEquals("IN-1001",
                responseEntity.getBody().getContent().get(7).getIndividual().getId());
    }

    //  Test chức năng search case 1 => 4, get có tham số.
    // Tham số search = "" => thì hiển thị ra list treatement
    @Test
    public void searchTreatement_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/treatement/list", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //   Search theo kiểu gần đúng - 1 Tham số: doctor = "Tùng" (sẽ ra 2 kết quả)
    //   expect output: doctor = "Lê Quốc Tùng"; totalPages = 1; totalElement = 2;
    @Test
    public void searchTreatement_2() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("Tùng", "", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("TR-1002",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("Lê Quốc Tùng",
                responseEntity.getBody().getContent().get(0).getDoctor());
        Assertions.assertEquals("PRRS",
                responseEntity.getBody().getContent().get(0).getMedicine());
        Assertions.assertEquals("Phòng LMHM",
                responseEntity.getBody().getContent().get(0).getKindOfDisease());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getQuantily());
        Assertions.assertEquals("Cho uống lại sau 3 tháng",
                responseEntity.getBody().getContent().get(0).getNote());
        Assertions.assertEquals(false,
                responseEntity.getBody().getContent().get(0).getDeleted());
        Assertions.assertEquals("IN-1002",
                responseEntity.getBody().getContent().get(0).getIndividual().getId());
    }

    //   Search theo kiểu gần đúng - 2 Tham số: doctor = "Tùng" & kindOfDisease = "LMHM" (sẽ ra 2 kết quả)
    //   expect output: doctor = "Lê Quốc Tùng"; kindOfDisease = "Phòng LMHM" totalPages = 1; totalElement = 2;
    @Test
    public void searchTreatement_3() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("Tùng", "LMHM", "", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("TR-1002",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("Lê Quốc Tùng",
                responseEntity.getBody().getContent().get(0).getDoctor());
        Assertions.assertEquals("PRRS",
                responseEntity.getBody().getContent().get(0).getMedicine());
        Assertions.assertEquals("Phòng LMHM",
                responseEntity.getBody().getContent().get(0).getKindOfDisease());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getQuantily());
        Assertions.assertEquals("Cho uống lại sau 3 tháng",
                responseEntity.getBody().getContent().get(0).getNote());
        Assertions.assertEquals(false,
                responseEntity.getBody().getContent().get(0).getDeleted());
        Assertions.assertEquals("IN-1002",
                responseEntity.getBody().getContent().get(0).getIndividual().getId());
    }

    //   Search theo kiểu gần đúng - 3 Tham số: doctor = "Tùng" & kindOfDisease = "LMHM" & cage = "1002" (sẽ ra 2 kết quả)
    //   expect output: doctor = "Lê Quốc Tùng"; kindOfDisease = "Phòng LMHM" & cage = "CA-1002" totalPages = 1; totalElement = 2;
    @Test
    public void searchTreatement_4() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("Tùng", "LMHM", "1002", 0);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("TR-1002",
                responseEntity.getBody().getContent().get(0).getId());
        Assertions.assertEquals("Lê Quốc Tùng",
                responseEntity.getBody().getContent().get(0).getDoctor());
        Assertions.assertEquals("PRRS",
                responseEntity.getBody().getContent().get(0).getMedicine());
        Assertions.assertEquals("Phòng LMHM",
                responseEntity.getBody().getContent().get(0).getKindOfDisease());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(0).getQuantily());
        Assertions.assertEquals("Cho uống lại sau 3 tháng",
                responseEntity.getBody().getContent().get(0).getNote());
        Assertions.assertEquals(false,
                responseEntity.getBody().getContent().get(0).getDeleted());
        Assertions.assertEquals("IN-1002",
                responseEntity.getBody().getContent().get(0).getIndividual().getId());
        Assertions.assertEquals("CA-1002",
                responseEntity.getBody().getContent().get(0).getIndividual().getCage().getId());
    }

    //   Search với 3 Tham số đều là null: doctor = "null" & kindOfDisease = "null" & cage = "null"
    //   expect output: 204;
    @Test
    public void searchTreatement_5() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("null", "null", "null", 0);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //   Search với  Tham số không tồn tại: doctor = "asdasdasd"
    //   expect output: 204;
    @Test
    public void searchTreatement_6() {
        ResponseEntity<Page<Treatement>> responseEntity
                = this.treatementController.getListRealEstateNews("asdasdasd", "", "", 0);
        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }
}
