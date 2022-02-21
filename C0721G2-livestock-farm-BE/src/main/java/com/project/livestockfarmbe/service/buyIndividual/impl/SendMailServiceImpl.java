package com.project.livestockfarmbe.service.buyIndividual.impl;

import com.project.livestockfarmbe.model.buyIndividual.BuyIndividual;
import com.project.livestockfarmbe.service.buyIndividual.ISendMailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class SendMailServiceImpl implements ISendMailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendMail(BuyIndividual buyIndividual) throws javax.mail.MessagingException {
        String mailContent = "";
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("plthienbkdn@gmail.com");
        helper.setTo("hungnn88dn@gmail.com");
        helper.setSubject("Liên hệ mua cá thể");
        mailContent = "<p>Chào bạn </p> \n" +
                "Tôi tên là : " + buyIndividual.getName()  + "\n" +  "<br>" +
                "Số điện thoại: " + buyIndividual.getPhoneNumber() + "<br>" +
                "Địa chỉ: " + buyIndividual.getAddress() + "<br>" +
                "Tôi cần hỗ trợ : " + buyIndividual.getContent() + "<br>" +
                "<p>Thanks and Regards</p>" +
                "<p>------------------------------------------</p>" +
                "<p>Pig Farm Group</p>" +
                "<p>pigfarmgroup.com.</p>\n" +
                "<p>Địa chỉ: Tòa nhà Hưng Thịnh Group, số 99 đường Lê Duẩn</p>" +
                "<p>Email: plthienbkdn@gmail.com</p>" +
                "<p>Số điện thoại: 0905686868</p>";
        helper.setText(mailContent, true);
        emailSender.send(message);
    }
}