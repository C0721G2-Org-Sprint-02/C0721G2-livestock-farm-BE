package com.project.livestockfarmbe;

import com.project.livestockfarmbe.controller.IndividualController;
import com.project.livestockfarmbe.model.individual.Individual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class IndividualController_listIndividual {

    @Autowired
    private IndividualController individualController;

    @Autowired
    private MockMvc mockMvc;

    //  Trường hợp Trả về list có size > 0, các tham số tìm kiếm đầu vào rỗng, trả về danh sách tất cả các cá thể
    @Test
    public void getIndividualList_1() {

        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "","","","","");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //Cá thể đầu tiên trong list có size bằng 5, page đầu tiên, có id là "IN-1001"
    @Test
    public void getIndividualList_2() {
        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "","","","","");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(19, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("IN-1001",
                responseEntity.getBody().getContent().get(0).getId());
    }

    //  Không có dữ liệu page > total page
    @Test
    public void getIndividualList_3() {

        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(10,"id","asc",
                "","","","","");

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }

    //  Test chức năng search, tìm kiếm chính xác Với tham số đầu vào individualId="IN-1001",
    //  dateIn="", dateOut="", status = "", cageId=""
    //  Kết quả trả về cá thể có ID IN-1001
    @Test
    public void searchIndividual_1() {
        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "IN-1001","","","","");


        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("IN-1001",
                responseEntity.getBody().getContent().get(0).getId());
    }

    //  Test chức năng search, tìm kiếm gần chính xác Với tham số cageId="CA-1001", các tham số còn lại rỗng
    //  individualId="", dateIn="", dateOut="", status = "",
    //  kết quả trả về 4 cá thể có cageId="CA-1001"
    @Test
    public void searchIndividual_2() {
        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "","CA-1001","","","");


        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
    }

    //  Test chức năng search, tìm kiếm gần chính xác Với tham số cageId="CA-1001", dateIn="2021-01-11"
    //  các tham số còn lại rỗng individualId="", dateOut="", status = "",
    //  kết quả trả về 2 cá thể có cageId="CA-1001" và dateIn="2021-01-11"
    @Test
    public void searchIndividual_3() {
        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "","CA-1001","2021-01-11","","");


        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
    }

    //  Test chức năng search, tìm kiếm gần chính xác Với tham số cageId="CA-1001", dateIn="2021-01-11",
    //  dateOut="2021-12-01" các tham số còn lại rỗng individualId="", status = "",
    //  kết quả trả về 1 cá thể có cageId="CA-1001" và dateIn="2021-01-11", dateOut="2021-12-01"
    @Test
    public void searchIndividual_4() {
        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "","CA-1001","2021-01-11","2021-12-01","");


        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
    }

    //  Test chức năng search, tìm kiếm gần chính xác Với tham số cageId="CA-1001", dateIn="2021-01-11",
    //  dateOut="2021-12-01", status = "1", các tham số còn lại rỗng individualId="",
    //  kết quả trả về 0 cá thể, no content
    @Test
    public void searchIndividual_5() {
        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "","CA-1001","2021-01-11","2021-12-01","1");


        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());

    }

    //  Test chức năng search, tìm kiếm gần chính xác Với tham số cageId="CA-1001", dateIn="2021-01-11",
    //  dateOut="2021-12-01", status = "0", các tham số còn lại rỗng individualId="",
    //  kết quả trả về 1 cá thể
    @Test
    public void searchIndividual_6() {
        ResponseEntity<Page<Individual>> responseEntity
                = this.individualController.showIndividualList(0,"id","asc",
                "","CA-1001","2021-01-11","2021-12-01","0");


        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
    }





}
