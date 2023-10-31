package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<DriverDTO> getAllCustomer() {
        return modelMapper.map(driverRepo.findAll(), new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        driver.setUser(new User(driver.getUser().getUserName(), driver.getUser().getUserPassword(), "DRIVER", "ACTIVE"));

        if (driverRepo.existsById(driverDTO.getDriverId())) {
            throw new RuntimeException("Driver ID Duplicated.");
        } else if (driverRepo.existsById(driverDTO.getUser().getUserName())) {
            throw new RuntimeException("This username is already taken.");
        }

        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/uploads/driver/nicImages");
            File file2 = new File(path + "/uploads/driver/drivingLicenseImages");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'nicImages' created.");
            }

            if (!file2.exists()) {
                file2.mkdirs();
                System.out.println("Directory 'drivingLicenseImages' created.");
            }


            File nicFile = new File(file.getAbsolutePath() + "/" + driverDTO.getDriverNicFrontFilePath().getOriginalFilename());
            if (nicFile.exists()) {
                throw new RuntimeException("File 'nicImages/" + nicFile.getName() + "' already exists.");
            } else {
                driverDTO.getDriverNicFrontFilePath().transferTo(nicFile);
                driver.setDriverNicFrontFilePath("uploads/driver/nicImages/" + nicFile.getName());
            }

            File licenseFile = new File(file2.getAbsolutePath() + "/" + driverDTO.getDriverDrivingLicenseFrontFilePath().getOriginalFilename());
            if (licenseFile.exists()) {
                throw new RuntimeException("File 'drivingLicenseImages/" + licenseFile.getName() + "' already exists.");
            } else {
                driverDTO.getDriverDrivingLicenseFrontFilePath().transferTo(licenseFile);
                driver.setDriverDrivingLicenseFrontFilePath("uploads/driver/drivingLicenseImages/" + licenseFile.getName());
            }

            System.out.println(driver);
            driverRepo.save(driver);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {

    }

    @Override
    public void deleteDriver(String driverId, DriverDTO driverDTO) {

    }
}
