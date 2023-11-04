package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.meta.DriverImgDTO;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<DriverImgDTO> getAllCustomer() {
        return modelMapper.map(driverRepo.findAll(), new TypeToken<ArrayList<DriverImgDTO>>() {
        }.getType());
    }

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        driver.setUser(new User(driver.getUser().getUserName(), driver.getUser().getUserPassword(), "DRIVER", "ACTIVE"));

        try {
            String path = System.getProperty("user.dir");
            Path projectPath = Paths.get(path).getParent().getParent().getParent().resolve("/home/sehan-ranaweera/Documents/My GitHub Repositories/Easy_Car_Rental_Spring_Project/Easy_Car_Rental_With_Spring_AAD_Final_Project/Easy_Car_Rental_Front_End");

            File file = new File(projectPath + "/uploads");
            System.out.println("\n\n\n" + projectPath + "\n\n\n");
            file.mkdir();

            System.out.println(driverDTO.getDriverNicFrontFilePath());
            System.out.println(driverDTO.getDriverDrivingLicenseFrontFilePath());

            driverDTO.getDriverNicFrontFilePath().transferTo(new File(file.getAbsolutePath() + "/" + driverDTO.getDriverNicFrontFilePath().getOriginalFilename()));
            driverDTO.getDriverDrivingLicenseFrontFilePath().transferTo(new File(file.getAbsolutePath() + "/" + driverDTO.getDriverDrivingLicenseFrontFilePath().getOriginalFilename()));

            driver.setDriverNicFrontFilePath("/uploads/" + driverDTO.getDriverNicFrontFilePath().getOriginalFilename());
            driver.setDriverDrivingLicenseFrontFilePath("/uploads/" + driverDTO.getDriverDrivingLicenseFrontFilePath().getOriginalFilename());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\n\n\n" + driver);
        driverRepo.save(driver);
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {

    }

    @Override
    public void deleteDriver(String driverId, DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getDriverId())) {
            throw new RuntimeException("Wrong Driver ID.Please Enter Correct ID..!");
        }

        driverRepo.deleteById(driverId);
    }
}
