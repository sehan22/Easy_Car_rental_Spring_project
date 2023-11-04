package lk.ijse.spring.controller;

import lk.ijse.spring.dto.RentRequestDTO;
import lk.ijse.spring.service.RentRequestService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rentrequest")
@CrossOrigin
public class RentRequestController {
    @Autowired
    RentRequestService rentRequestService;

    @GetMapping
    public ResponseUtil getAllRentalRequests() {
        List<RentRequestDTO> allRentRequests = rentRequestService.getAllRentRequests();
        System.out.println(allRentRequests);
        return new ResponseUtil("OK", "Successfully Loaded!", rentRequestService.getAllRentRequests());
    }
}
