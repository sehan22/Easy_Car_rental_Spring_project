package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.MaintenanceDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.MaintenanceService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maintenance")
@CrossOrigin
public class MaintenanceController {
    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping
    public ResponseUtil getAllMaintenances() {
        return new ResponseUtil("Ok", "Maintenances Successfully Loaded", maintenanceService.getAllMaintenances());
    }

    @PostMapping
    public ResponseUtil saveMaintenance(@ModelAttribute MaintenanceDTO maintenanceDTO, @ModelAttribute CarDTO carDTO) {
        carDTO.setCarStatus("MAINTAIN");
        maintenanceDTO.setCar(carDTO);

        System.out.println("\n\n=============================");

        System.out.println(maintenanceDTO);
        System.out.println(carDTO);

        System.out.println("\n\n=============================");
//        maintenanceService.saveMaintenance(maintenanceDTO);
        return new ResponseUtil("OK", "Service Added Successfully!", maintenanceDTO);
    }
}
