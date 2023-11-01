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
        System.out.println(carService.getAllCars());
        return new ResponseUtil("Ok","Cars Successfully Loaded",carService.getAllCars());
    }

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO carDTO) {
        System.out.println(carDTO.toString());
        carService.saveCar(carDTO);
        return new ResponseUtil("OK", "Car Registration Successfully!", null);
    }

    @PutMapping
    public ResponseUtil updateCar(@ModelAttribute CarDTO carDTO) {
        System.out.println(carDTO.toString());
        carService.updateCar(carDTO);
        return new ResponseUtil("OK", "Car Registration Successfully!", carDTO);
    }
}
