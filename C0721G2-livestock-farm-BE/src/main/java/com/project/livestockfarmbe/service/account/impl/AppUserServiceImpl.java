package com.project.livestockfarmbe.service.account.impl;



import com.project.livestockfarmbe.dto.AppUserDTO;
import com.project.livestockfarmbe.model.account.AppUser;
import com.project.livestockfarmbe.payload.request.CustomerSocial;
import com.project.livestockfarmbe.repository.account.IAppUserRepository;
import com.project.livestockfarmbe.service.account.IAppUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RoleServiceImpl roleService;


    @Override
    public AppUser getAppUserByEmail(String email) {
        return null;
//        return appUserRepository.getAppUserByEmailCustomer(email);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return appUserRepository.existsUserByEmail(email) != null;
    }

    @Override
    public void addVerificationCode(String email) throws MessagingException, UnsupportedEncodingException {
        String username = appUserRepository.existsUserByEmail(email);
        String code = RandomString.make(64);
        appUserRepository.addVerificationCode(code, username);
        this.sendVerificationEmailForResetPassWord(username, code, email);
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
            appUserRepository.deleteVerificationCode(username);
        });
    }

    @Override
    public void saveNewPassword(String passwordEncode, String code) {
        appUserRepository.saveNewPassword(passwordEncode, code);
        appUserRepository.deleteVerificationCode(code);
    }

    @Override
    public Boolean findUserByVerificationCode(String code) {
        return appUserRepository.findUserByVerificationCode(code) != null;
    }

    @Override
    public AppUser createCustomerSocial(CustomerSocial customerSocial) {
//        Customer customer = new Customer();
//        customer.setName(customerSocial.getName());
//        customer.setEmail(customerSocial.getEmail());
//
//        Image image = new Image();
//        image.setUrl(customerSocial.getUrlImg());
//        customer.setImage(image);
//
//        AppUser appUser = new AppUser();
//        appUser.setUsername(customerSocial.getEmail());
//        appUser.setPassword(customerSocial.getPassword());
//        appUser.setEnabled(true);
//        Set<Role> roles = new HashSet<>();
//        Role role = roleService.findRoleByName("ROLE_CUSTOMER");
//        roles.add(role);
//
//        appUser.setRoles(roles);
//
//        customer.setAppUser(appUser);
//        this.customerService.saveCustomerSocial(customer);
//        return appUser;

        return null;
    }


    public void sendVerificationEmailForResetPassWord(String userName, String randomCode, String email) throws MessagingException, UnsupportedEncodingException {
        String subject = "Farm C0721G2 - X??c th???c t??i kho???n c???a b???n";
        String mailContent = "";
        String confirmUrl = "http://localhost:4200/security/verify-reset-password?code=" + randomCode;


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("kukuku12113@gmail.com", "T???p ??o??n ch??n nu??i h??ng ?????u Ch??u ?? C0721G2 Group");
        helper.setTo(email);
        helper.setSubject(subject);
        mailContent = "<p style='color:red;font-size: 20px'>Xin ch??o " + userName + " ,<p>" + "<p style='font-size: 16px'> Nh???n v??o link sau ????? thay ?????i m???t kh???u c???a b???n:</p>" +
                "<h3><a href='" + confirmUrl + "'>Link X??c th???c( nh???n v??o ????y)!</a></h3>" +
                "<hr>" +
                "<div style=\"text-size-adjust: none !important; -ms-text-size-adjust: none !important; -webkit-text-size-adjust: none !important;\"><span style=\"margin: 0px; padding: 0px; line-height: 100%; display: block; font-family: Helvetica, Arial, sans-serif;\"> </span><span style=\"margin:0; padding:0; font-family: Helvetica, Arial, sans-serif; font-size: 15px; line-height:20px; color: #212121; display:block;\">\n" +
                "        <span style=\"font-weight: bold; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">Phan L?? Thanh Hi???n</span><span style=\"display: inline; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif;\"> / </span><span style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">Chuy??n vi??n</span><span style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span><a href=\"mailto:plthienbkdn@gmail.com\"\n" +
                "           style=\"color: rgb(71, 124, 204); text-decoration: none; display: inline;\">plthienbkdn@gmail.com</a><span\n" +
                "                style=\"display: inline; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif;\"> / </span><span\n" +
                "                style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">0794197483</span></span>\n" +
                "    <p style=\"margin:0; padding:0; line-height:20px; display:block;width:100%; font-size:1;\"><img src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"508\" height=\"10\" style=\"display: block; width: 100%; height: 5px;\">\n" +
                "    </p><span style=\"margin: 0px; padding: 0px; font-family: Helvetica, Arial, sans-serif; font-size: 15px; line-height: 25px; display: block;\"> <span\n" +
                "            style=\"font-weight: bold; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">T???p ??o??n ch??n nu??i h??ng ?????u Ch??u ?? C0721-G2 Group</span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); display: inline; font-family: Helvetica, Arial, sans-serif;\">Office: </span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">(0292) 3 837 838</span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); display: inline; font-family: Helvetica, Arial, sans-serif;\"> / </span><span\n" +
                "            style=\"color: rgb(33, 33, 33); display: inline; font-family: Helvetica, Arial, sans-serif;\">Fax: </span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">999-9999-999</span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">Chi nh??nh ???? N???ng T???ng 9, t??a nh?? V??nh Trung Plaza, s??? 255 ??? 257 H??ng V????ng, ph?????ng V??nh Trung, qu???n Thanh Kh??, TP. ???? N???ng</span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">Chi nh??nh TP. H??? Ch?? Minh T???ng 3, T??a nh?? Viettel Complex, 285 C??ch M???ng Th??ng T??m, Ph?????ng 12, Qu???n 10, TP. H??? Ch?? Minh</span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"display: block; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif;\"> <a\n" +
                "            href=\"http://localhost:4200/\" style=\"color: rgb(71, 124, 204); text-decoration: none; display: inline;\">http://localhost:4200/home</a></span> <p\n" +
                "            style=\"margin:0; padding:0; line-height:18px; display:block;width:100%; font-size:1;\"> <img\n" +
                "            src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"508\" height=\"10\"\n" +
                "            style=\"display: block; width: 100%; height: 5px;\">\n" +
                "</p> </span> <span\n" +
                "        style=\"margin: 0px; padding: 0px; line-height: 100%; font-size: 1px; display: block; font-family: Helvetica, Arial, sans-serif;\"> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H25Y6K\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"twitter.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/twitter.png\"\n" +
                "                                                                                                       alt=\"Twitter\"></a> <span\n" +
                "        style=\"white-space: nowrap; font-family: Helvetica, Arial, sans-serif; display: inline;\"> <img\n" +
                "        src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"2\"> </span> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H1N6GV\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"facebook.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/facebook.png\"\n" +
                "                                                                                                       alt=\"Facebook\"></a> <span\n" +
                "        style=\"white-space: nowrap; font-family: Helvetica, Arial, sans-serif; display: inline;\"> <img\n" +
                "        src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"2\"> </span> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H2J2VT\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"linkedin.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/linkedin.png\"\n" +
                "                                                                                                       alt=\"LinkedIn\"></a> <span\n" +
                "        style=\"white-space: nowrap; font-family: Helvetica, Arial, sans-serif; display: inline;\"> <img\n" +
                "        src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"2\"> </span> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H13TNJ\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"youtube.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/youtube.png\"\n" +
                "                                                                                                       alt=\"Youtube\"></a>\n" +
                "</span>\n" +
                "</div>";
        helper.setText(mailContent, true);
        javaMailSender.send(message);

    }


    @Override
    public String findPasswordByUsername(String username) {
        return appUserRepository.findPasswordByUsername(username);
    }


    @Override
    public void updatePassword(AppUserDTO appUserDTO) {
        AppUser appUser = this.findAppUserByUserName(appUserDTO.getUsernameChange());
        appUser.setPassword(appUserDTO.getPassword());
        appUserRepository.save(appUser);
//        appUserRepository.saveNewPassword(appUserDTO.getPassword(), appUserDTO.getUsernameChange());
    }

    @Override
    public AppUser findAppUserByUserName(String id) {
//        return appUserRepository.findAppUserByUsername(id).orElseThrow(() -> new AppUserException(
//                "kh??ng th??? t??m th???y id " + id + ""));
        return null;
    }

    @Override
    public AppUser getAppUserByEmployee(String id) {
        return appUserRepository.getAppUserByEmployee(id);
    }

    // DoanhNV ki???m tra username
    public boolean existsByUserName(String username) {
        return appUserRepository.existsAppUserByUsername(username);
    }
}