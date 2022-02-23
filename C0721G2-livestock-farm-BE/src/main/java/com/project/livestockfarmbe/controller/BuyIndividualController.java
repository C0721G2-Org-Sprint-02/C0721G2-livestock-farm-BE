package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.model.buyIndividual.BuyIndividual;
import com.project.livestockfarmbe.service.buyIndividual.IBuyIndividualService;
import com.project.livestockfarmbe.service.buyIndividual.ISendMailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping(value = "/api/buy_individual")
@CrossOrigin("http://localhost:4200")
public class BuyIndividualController {
    @Qualifier("buyIndividualServiceImpl")
    @Autowired
    IBuyIndividualService buyIndividualService;

    @Qualifier("sendMailServiceImpl")
    @Autowired
    ISendMailService iSendMailService;

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid BuyIndividual buyIndividual,
                                                 BindingResult bindingResult) throws UnsupportedEncodingException, MessagingException {
        if (bindingResult.hasErrors()) {
            System.out.println("Test error");
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        System.out.println(buyIndividual.toString());
        this.buyIndividualService.saveBuyIndividual(buyIndividual);
        this.iSendMailService.sendMail(buyIndividual);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}