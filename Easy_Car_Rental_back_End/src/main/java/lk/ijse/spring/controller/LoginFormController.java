package lk.ijse.spring.controller;

import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginFormController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseUtil getAllDrivers() {
        System.out.println(userService.getAllUsers());
        return new ResponseUtil("OK", "Drivers Successfully Loaded", userService.getAllUsers());
    }
}
