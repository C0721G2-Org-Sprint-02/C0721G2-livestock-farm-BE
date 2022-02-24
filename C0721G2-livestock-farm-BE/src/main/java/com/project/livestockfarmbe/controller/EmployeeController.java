package com.project.livestockfarmbe.controller;

import com.project.livestockfarmbe.dto.EmployeeDTO;
import com.project.livestockfarmbe.dto.EmployeeEditDTO;
import com.project.livestockfarmbe.dto.EmployeeServiceDTO;
import com.project.livestockfarmbe.model.account.AppUser;
import com.project.livestockfarmbe.model.account.Role;
import com.project.livestockfarmbe.model.employee.Employee;
import com.project.livestockfarmbe.repository.employee.IEmployeeRepository;
import com.project.livestockfarmbe.service.account.IRoleService;
import com.project.livestockfarmbe.service.account.impl.AppUserServiceImpl;
import com.project.livestockfarmbe.service.employee.IEmployeeService;
import com.project.livestockfarmbe.ultilities.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    AppUserServiceImpl appUserService;

    @Autowired
    IRoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //    TranNN - Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable String id) {

        Optional<Employee> employeeOptional = this.iEmployeeService.findByIdOp(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.deleteById(id);
        Log.info(id+ " is deleted");
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    //    TranNN - List Employee
    @GetMapping("/list")
    public ResponseEntity<Page<EmployeeServiceDTO>> findAllEmployees(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer sort,
                                                            @RequestParam(defaultValue = "", value = "search") String search, @RequestParam(defaultValue = "", value = "role") String role) {
        Pageable pageable;
        if (role.equals("0")) {
            role = "";
        }
        switch (sort) {
            case 1:
                pageable = PageRequest.of(page, 4, Sort.by("name").ascending());
                break;
            case 2:
                pageable = PageRequest.of(page, 4, Sort.by("name").descending());
                break;
            case 3:
                pageable = PageRequest.of(page, 4, Sort.by("address").ascending());
                break;
            case 4:
                pageable = PageRequest.of(page, 4, Sort.by("address").descending());
                break;
            case 5:
                pageable = PageRequest.of(page, 4, Sort.by("date_of_birth").ascending());
                break;
            case 6:
                pageable = PageRequest.of(page, 4, Sort.by("date_of_birth").descending());
                break;
            default:
                pageable = PageRequest.of(page, 4, Sort.by("id").ascending());
        }
        Page<EmployeeServiceDTO> dtoPage;
        dtoPage = iEmployeeService.findByEmployeeByName(search,pageable);
        if (dtoPage.isEmpty()){
            dtoPage = iEmployeeService.employeeList(search, role, pageable);
        }
        if(dtoPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }
    //DoanhNV lấy id
    @GetMapping(value = "/edit/{id}")
    public ResponseEntity<Object> findByIdEmployee(@PathVariable String id) {
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        EmployeeEditDTO employeeEditDTO = new EmployeeEditDTO();
        BeanUtils.copyProperties(employeeOptional.get(), employeeEditDTO);
        Set<Role> roles = employeeOptional.get().getAppUser().getRoles();
        Long idRole = 0L;
        for (Role role : roles) {
            idRole = role.getId();
        }
        employeeEditDTO.setRoleDTO(idRole);
        return new ResponseEntity<Object>(employeeEditDTO, HttpStatus.OK);


    }

    //DoanhNV create
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        //kiểm tra email có bị trùng lặp hay không
        Map<String, String> listErrors = new HashMap<>();
        if (appUserService.existsByUserName(employeeDTO.getEmail())) {
            System.out.println("Test");
            listErrors.put("errorEmail", "Email đã có người sử dụng");
            return ResponseEntity.badRequest().body(listErrors);
        }
        System.out.println(employeeDTO.toString());

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);



        // Set role
        Role role = roleService.getRoleById(employeeDTO.getRoleDTO());
        Set<Role> roles = new HashSet<>();
        roles.add(role);


        //tạo account
        AppUser appUser = new AppUser();
        appUser.setUsername(employeeDTO.getEmail());
        appUser.setPassword(bCryptPasswordEncoder.encode("123"));
        appUser.setEnabled(true);
        appUser.setRoles(roles);
        appUser.setEnabled(true);

        employee.setAppUser(appUser);
        this.iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //DoanhNV edit
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody @Valid EmployeeEditDTO employeeEditDTO,
                                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);

        }
        //kiểm tra email có bị trùng lặp hay không
        //Map<String, String> listErrors = new HashMap<>();
//        if (appUserService.existsByUserName(employeeDTO.getEmail())) {
//
//            listErrors.put("errorEmail", "Email đã có người sử dụng");
//            return ResponseEntity.badRequest().body(listErrors);
//        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEditDTO, employee);

        // Set role
        Role role = roleService.getRoleById(employeeEditDTO.getRoleDTO());
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        AppUser appUser = new AppUser();
        appUser.setRoles(roles);
        appUser.setUsername(employeeEditDTO.getEmail());
        employee.setAppUser(appUser);

        this.iEmployeeService.saveEmployeeDTO(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
