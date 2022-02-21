package com.project.livestockfarmbe.service.buyIndividual;

import com.project.livestockfarmbe.model.buyIndividual.BuyIndividual;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public interface ISendMailService {
    void sendMail(BuyIndividual buyIndividual)
            throws MessagingException, UnsupportedEncodingException, javax.mail.MessagingException;
}