package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.IndividualDTO;
import com.project.livestockfarmbe.model.cage.Cage;
import com.project.livestockfarmbe.model.individual.Individual;
import com.project.livestockfarmbe.service.cage.ICageService;
import com.project.livestockfarmbe.service.individual.IIndividualService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@RestController
@RequestMapping(value = "/api/individual")
@CrossOrigin(value = "http://localhost:4200", allowCredentials = "true")
public class IndividualController {

    @Autowired
    IIndividualService individualService;

    @Qualifier("cageServiceImpl")
    @Autowired
    ICageService cageService;

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
    public ResponseEntity<Object> readExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Individual individual = new Individual();
            XSSFRow row = worksheet.getRow(i);
            String cageId = row.getCell(0).getStringCellValue();
            Cage cage = cageService.findCageById(cageId).orElse(null);
            individual.setCage(cage);

            Date dateIn = row.getCell(1).getDateCellValue();
            Date dateOut = row.getCell(2).getDateCellValue();

            LocalDate dateInLocal = dateIn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateOutLocal = dateOut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            individual.setDateIn(dateInLocal);
            individual.setDateOut(dateOutLocal);


            individual.setWeight(row.getCell(3).getNumericCellValue());
            individual.setStatus((int) row.getCell(4).getNumericCellValue());

            individualService.save(individual);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Individual> findIndividualbyId(@PathVariable("id") String id) {
        Individual individual = individualService.findIndividualById(id);
        if (individual == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(individual, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> createNewindividual(@RequestBody @Valid IndividualDTO individualDTO,
                                                      BindingResult bindingResult) {
        new IndividualDTO().validate(individualDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Object>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        individualService.save(individualDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/edit")
    public ResponseEntity<Object> editOldIndividual(@RequestBody @Valid IndividualDTO individualDTO,
                                                    BindingResult bindingResult) {
        new IndividualDTO().validate(individualDTO, bindingResult);
        if (findIndividualbyId(individualDTO.getId())==null) {
            if (individualDTO.getId().equals(individualService.findIndividualById(individualDTO.getId()))) {
                if (bindingResult.hasErrors()) {
                    return new ResponseEntity<Object>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
                }
            }
            Object individual = individualService.save(individualDTO);
            return new ResponseEntity<>(individual, HttpStatus.OK);
        }
        String message = "id not exist";
        return new ResponseEntity<Object>(message,HttpStatus.NOT_FOUND);
    }
}


