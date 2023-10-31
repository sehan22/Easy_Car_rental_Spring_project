package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService driverService;

    @GetMapping
    public ResponseUtil getAllDrivers() {
        System.out.println(driverService.getAllCustomer());
        return new ResponseUtil("OK", "Drivers Successfully Loaded", driverService.getAllCustomer());
    }

    @PostMapping
    public ResponseUtil addDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO) {
        driverDTO.setUser(userDTO);
        driverService.saveDriver(driverDTO);
        return new ResponseUtil("OK", "Account Create Successfully!", null);
    }
}
