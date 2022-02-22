package com.project.livestockfarmbe.controller;



import com.project.livestockfarmbe.jwt.JwtUtils;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.payload.request.LoginRequest;
import com.project.livestockfarmbe.payload.request.ResetPasswordRequest;
import com.project.livestockfarmbe.payload.request.VerifyRequest;
import com.project.livestockfarmbe.payload.response.JwtResponse;
import com.project.livestockfarmbe.payload.response.MessageResponse;
import com.project.livestockfarmbe.service.account.impl.AppUserServiceImpl;
import com.project.livestockfarmbe.service.account.impl.MyUserDetailsImpl;
import com.project.livestockfarmbe.service.employee.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin("http://localhost:4200")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AppUserServiceImpl appUserService;

//    @Autowired
//    private CustomerServiceImpl customerService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Value("${google.clientId}")
//    String googleClientId;
//
//    @Value("${secretPsw}")
//    String secretPsw;


    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        MyUserDetailsImpl myUserDetails = (MyUserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateToken(myUserDetails);

//        System.out.println(myUserDetails);

        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

//        System.out.println(roles);
        JwtResponse jwtResponse = new JwtResponse();
        String urlImgDefault = "https://cdyduochopluc.edu.vn/wp-content/uploads/2019/07/anh-dai-dien-FB-200-1.jpg";

            Employee employee = employeeService.getEmployeeByUsername(myUserDetails.getUsername());
            jwtResponse.setName(employee.getName());
            jwtResponse.setJwtToken(jwtToken);
            jwtResponse.setUsername(myUserDetails.getUsername());
            jwtResponse.setEmail(employee.getEmail());
            jwtResponse.setRoles(roles);
            jwtResponse.setIdCustomer(employee.getId());
            jwtResponse.setUrlImg(employee.getImage() == null ? urlImgDefault:employee.getImage());

        return ResponseEntity.ok(jwtResponse);

    }

    @PostMapping("/send-verification-email")
    public ResponseEntity<Object> reset(@RequestBody LoginRequest loginRequest) throws MessagingException, UnsupportedEncodingException {
        if (appUserService.existsUserByEmail(loginRequest.getEmail())) {
            appUserService.addVerificationCode(loginRequest.getEmail());
            return ResponseEntity.ok(new MessageResponse("Đã gửi email xác nhận"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không tồn tại"));
    }

    @PostMapping("/check-verification-code")
    public ResponseEntity<Object> checkVerificationCode(@RequestBody VerifyRequest verifyRequest) {
        Boolean isVerified = appUserService.findUserByVerificationCode(verifyRequest.getCode());
        if (Boolean.TRUE.equals(isVerified)) {
            return ResponseEntity.ok(new MessageResponse("valid"));
        } else {
            return ResponseEntity.ok(new MessageResponse("invalid"));
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Object> doResetPassword(@Valid @RequestBody ResetPasswordRequest resetPassRequest) {
        if (resetPassRequest.getNewPassword().equals(resetPassRequest.getReNewPassword())) {
            appUserService.saveNewPassword(bCryptPasswordEncoder.encode(resetPassRequest.getNewPassword()), resetPassRequest.getVerificationCode());
            return ResponseEntity.ok(new MessageResponse("success"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("error"));

    }
//
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}