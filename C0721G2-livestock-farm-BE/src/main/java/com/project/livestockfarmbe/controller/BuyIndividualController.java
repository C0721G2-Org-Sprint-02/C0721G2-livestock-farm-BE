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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/buy_individual")
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
