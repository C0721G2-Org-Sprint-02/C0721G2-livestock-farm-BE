package com.project.livestockfarmbe;

import com.project.livestockfarmbe.controller.EmployeeController;
import com.project.livestockfarmbe.dto.EmployeeServiceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class LivestockFarmBeApplicationTests {

    @Autowired
    private EmployeeController employeeController;


    //    Danh sách tất cả nhân viên
    @Test
    public void showAllEmployees0001() {
        ResponseEntity<Page<EmployeeServiceDTO>> responseEntity
                = this.employeeController.findAllEmployees(0, 0, "", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    //    tìm kiếm theo tên "Nguyen Van A"
    @Test
    public void searchEmployees0001() {
        ResponseEntity< Page< EmployeeServiceDTO > > responseEntity
                = this.employeeController.findAllEmployees(0, 0, "Nguyen Van A", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("NV-1001",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Nguyen Van A",
                responseEntity.getBody().getContent().get(1).getName());
        Assertions.assertEquals("Da Nang",
                responseEntity.getBody().getContent().get(1).getAddress());
        Assertions.assertEquals("123456789",
                responseEntity.getBody().getContent().get(1).getIdCard());
        Assertions.assertEquals("0901234567",
                responseEntity.getBody().getContent().get(1).getPhoneNumber());
        Assertions.assertEquals("nguyena@gmail.com",
                responseEntity.getBody().getContent().get(1).getEmail());
        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(1).getGender());
        Assertions.assertEquals("1991-01-01",
                responseEntity.getBody().getContent().get(1).getDateOfBirth());
    }


    //    tìm kiếm theo username "admin"
    @Test
    public void searchEmployees0002() {
        ResponseEntity< Page< EmployeeServiceDTO > > responseEntity
                = this.employeeController.findAllEmployees(0, 0, "admin", "");
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(2, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("NV-1003",
                responseEntity.getBody().getContent().get(1).getId());
        Assertions.assertEquals("Nguyen Thi C",
                responseEntity.getBody().getContent().get(1).getName());
        Assertions.assertEquals("Ha Noi",
                responseEntity.getBody().getContent().get(1).getAddress());
        Assertions.assertEquals("123456789",
                responseEntity.getBody().getContent().get(1).getIdCard());
        Assertions.assertEquals("0901234567",
                responseEntity.getBody().getContent().get(1).getPhoneNumber());
        Assertions.assertEquals("nguyenc@gmail.com",
                responseEntity.getBody().getContent().get(1).getEmail());
        Assertions.assertEquals(0,
                responseEntity.getBody().getContent().get(1).getGender());
        Assertions.assertEquals("1992-01-14",
                responseEntity.getBody().getContent().get(1).getDateOfBirth());
        Assertions.assertEquals("NV-1004",
                responseEntity.getBody().getContent().get(2).getId());
        Assertions.assertEquals("Nguyen Van D",
                responseEntity.getBody().getContent().get(2).getName());
        Assertions.assertEquals("Ho Chi Minh",
                responseEntity.getBody().getContent().get(2).getAddress());
        Assertions.assertEquals("123456789",
                responseEntity.getBody().getContent().get(2).getIdCard());
        Assertions.assertEquals("0901234567",
                responseEntity.getBody().getContent().get(2).getPhoneNumber());
        Assertions.assertEquals("nguyend@gmail.com",
                responseEntity.getBody().getContent().get(2).getEmail());
        Assertions.assertEquals(0,
                responseEntity.getBody().getContent().get(2).getGender());
        Assertions.assertEquals("1993-01-11",
                responseEntity.getBody().getContent().get(2).getDateOfBirth());
    }
}
