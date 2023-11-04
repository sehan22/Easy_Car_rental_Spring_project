package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.meta.DriverImgDTO;

import java.util.ArrayList;

public interface DriverService {
    ArrayList<DriverImgDTO> getAllCustomer();
    void saveDriver(DriverDTO driverDTO);
    void updateDriver(DriverDTO driverDTO);
    void deleteDriver(String driverId, DriverDTO driverDTO);
}
