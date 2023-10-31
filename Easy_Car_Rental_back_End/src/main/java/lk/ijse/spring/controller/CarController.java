package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public ResponseUtil getAllCars() {
        return new ResponseUtil("Ok","Cars Successfully Loaded",null);
    }

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO carDTO) {
        System.out.println(carDTO.toString());
        carService.saveCar(carDTO);
        return new ResponseUtil("OK", "Car Registration Successfully!", null);
    }
}
