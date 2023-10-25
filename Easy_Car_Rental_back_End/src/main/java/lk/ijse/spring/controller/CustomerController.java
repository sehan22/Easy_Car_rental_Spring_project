package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @GetMapping
    public ResponseUtil addCustomer(){
        return new ResponseUtil("Ok","Customer Successfully Added",null);
    }
}
