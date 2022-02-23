package com.project.livestockfarmbe.service.account;



import com.project.livestockfarmbe.dto.AppUserDTO;
import com.project.livestockfarmbe.model.account.AppUser;
import com.project.livestockfarmbe.payload.request.CustomerSocial;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;


public interface IAppUserService {
    AppUser getAppUserByEmail(String email);

    boolean existsUserByEmail(String email);

    void addVerificationCode(String email) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String passwordEncode, String code);

    Boolean findUserByVerificationCode(String code);

    AppUser createCustomerSocial(CustomerSocial customerSocial);

//    boolean existsByUserName(String username);

    void updatePassword(AppUserDTO appUserDTO);

    String findPasswordByUsername(String username);

    AppUser findAppUserByUserName(String id);

    AppUser getAppUserByEmployee(String id);
}