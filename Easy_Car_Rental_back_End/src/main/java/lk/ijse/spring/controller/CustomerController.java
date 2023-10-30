package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerImgDTO;
import lk.ijse.spring.dto.Test;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.CustomerService;
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
        return new ResponseUtil("Ok","Customer Successfully Added",null);
    }

    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute UserDTO userDTO) {
        System.out.println("PostMapping");
        System.out.println(customerDTO.toString() + " " + userDTO.toString());
        return new ResponseUtil("OK", "Account Create Successfully!", customerDTO);
    }
}
