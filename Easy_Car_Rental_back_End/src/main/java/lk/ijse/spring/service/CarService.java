package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.meta.CarImgDTO;

import java.util.ArrayList;

public interface CarService {
    ArrayList<CarImgDTO> getAllCars();
    void saveCar(CarDTO carDTO);
    void updateCar(CarDTO carDTO);
    void deleteCar(String carId, CarDTO carDTO);
}
