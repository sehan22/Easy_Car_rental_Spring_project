package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CarService {
    ArrayList<CarDTO> getAllCars();
    void saveCar(CarDTO carDTO);
    void updateCar(CarDTO carDTO);
    void deleteCar(String carId, CarDTO carDTO);
}
