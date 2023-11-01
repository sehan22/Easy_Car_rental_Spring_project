package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.MaintenanceDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Maintenance;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.MaintenanceRepo;
import lk.ijse.spring.service.MaintenanceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {
    @Autowired
    MaintenanceRepo maintenanceRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<MaintenanceDTO> getAllMaintenances() {
        return modelMapper.map(maintenanceRepo.findAll(), new TypeToken<ArrayList<MaintenanceDTO>>() {
        }.getType());
    }

    @Override
    public void saveMaintenance(MaintenanceDTO maintenanceDTO) {
        if (maintenanceRepo.existsById(maintenanceDTO.getServiceId())) {
            throw new RuntimeException("Maintenance Id Duplicate");
        }

        Maintenance maintenance = modelMapper.map(maintenanceDTO, Maintenance.class);
        System.out.println("Entity : " + maintenance);

        Car car = carRepo.findById(maintenanceDTO.getCarId()).get();

        if (car.getCarStatus().equals("MAINTAIN")) {
            throw new RuntimeException("The car is still being maintained!");
        }

        if (car.getCarStatus().equals("RESERVED")) {
            throw new RuntimeException("The car is still reserved!");
        }

        if (car.getCarStatus().equals("AVAILABLE")) {
            /*save maintenance*/
            maintenanceRepo.save(maintenance);

            /*update car status*/
            car.setCarStatus("MAINTAIN");
        }
    }

    @Override
    public void updateMaintenance(MaintenanceDTO maintenanceDTO) {

    }

    @Override
    public void deleteMaintenance(String carId, MaintenanceDTO maintenanceDTO) {

    }
}
