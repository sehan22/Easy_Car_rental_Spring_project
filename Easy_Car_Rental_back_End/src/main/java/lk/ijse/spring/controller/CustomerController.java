package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerImgDTO;
import lk.ijse.spring.dto.Test;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseUtil getCustomer(){
        System.out.println(customerService.getAllCustomer());
        return new ResponseUtil("Ok","Customers Successfully Loaded",customerService.getAllCustomer());
    }

    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute UserDTO userDTO) {
        customerDTO.setUser(userDTO);
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Account Create Successfully!", null);
    }
}
