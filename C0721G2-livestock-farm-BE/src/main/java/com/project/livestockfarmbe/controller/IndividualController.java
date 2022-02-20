package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.service.individual.IIndividualService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/individual")
@CrossOrigin(value = "http://localhost:4200", allowCredentials = "true")
public class IndividualController {

    @Autowired
    IIndividualService individualService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Individual>> showIndividualList(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(value = "sortField", defaultValue = "id") String sortField,
            @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "") String individualId,
            @RequestParam(defaultValue = "") String cageId,
            @RequestParam(defaultValue = "") String dateIn,
            @RequestParam(defaultValue = "") String dateOut,
            @RequestParam(defaultValue = "") String status) {

        int size = 5;
        Page<Individual> individualPage = this.individualService.findAllIndividual(page, size, sortField,
                sortDirection, individualId, cageId, dateIn, dateOut, status);

        if (individualPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(individualPage, HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Individual> deleteIndividual(@PathVariable String id) {
        Individual individual = this.individualService.findIndividualById(id);

        if (individual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.individualService.deleteIndividual(individual);
        return new ResponseEntity<>(individual, HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Individual> findIndividualById(@PathVariable String id) {
        Individual individual = this.individualService.findIndividualById(id);

        if (individual == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(individual, HttpStatus.OK);

    }

    @PostMapping(value = "/upload")
    public void readExcelFile(@RequestParam("formData") MultipartFile file) throws IOException {

        List<Individual> individualList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Individual individual = new Individual();
            Cage cage = new Cage();
            XSSFRow row = worksheet.getRow(i);
            String cageId = row.getCell(0).getStringCellValue();
            individual.setCage();
            tempStudent.setContent(row.getCell(1).getStringCellValue());
            tempStudentList.add(tempStudent);
        }
    }

}
