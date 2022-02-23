package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.controller.CageController;
import com.project.livestockfarmbe.model.cage.Cage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class LiveStockFarm_ListCage {
    @Autowired
    CageController cageController;


    @Test
    public void getListEmployeeNull() {

        ResponseEntity<Page<Cage>> responseEntity
                = this.cageController.showCages(PageRequest.of(4, 10));

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }




    @Test
    public void getListEmployeeSuccess_Test1() {
        ResponseEntity<Page<Cage>> responseEntity =
                this.cageController.showCages(PageRequest.of(0,10));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(32,responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("CA-1014", responseEntity.getBody().getContent().get(3).getId());
        Assertions.assertEquals(100, responseEntity.getBody().getContent().get(3).getQuantily());
//        Assertions.assertEquals("2021-02-08", responseEntity.getBody().getContent().get(3).getCloseDate());
    }

    @Test
    public void getListEmployeeSuccess_Test2() {
        ResponseEntity<Page<Cage>> responseEntity =
                this.cageController.showCages(PageRequest.of(0,10));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(32,responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("CA-1002", responseEntity.getBody().getContent().get(2).getId());
        Assertions.assertEquals(100, responseEntity.getBody().getContent().get(2).getQuantily());
//        Assertions.assertEquals("2021-02-08", responseEntity.getBody().getContent().get(3).getCloseDate());
    }
}
