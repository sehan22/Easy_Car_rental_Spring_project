package lk.ijse.spring.controller;

import lk.ijse.spring.dto.RentRequestDTO;
import lk.ijse.spring.service.RentRequestService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentalController {
    @Autowired
    RentRequestService rentRequestService;

    @GetMapping
    public ResponseUtil getAllRentalRequests() {
        return new ResponseUtil("OK", "Successfully Loaded!", rentRequestService.getAllRentRequests());
    }

    @PostMapping
    public ResponseUtil saveRentRequest(@RequestBody RentRequestDTO rentRequestDTO) {
        System.out.println("\n\n\n\n"+rentRequestDTO+"\n\n\n\n");
        rentRequestService.saveRentRequests(rentRequestDTO);
        return new ResponseUtil("OK", "OK", rentRequestDTO);
    }
}
