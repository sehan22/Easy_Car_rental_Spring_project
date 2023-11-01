package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return modelMapper.map(carRepo.findAll(), new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public void saveCar(CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);

//        if (carRepo.existsById(carDTO.getCarId())) {
//            throw new RuntimeException("Car ID Duplicated.");
//        }

        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/uploads/car/carFrontViewImages");
            File file2 = new File(path + "/uploads/car/carBackViewImages");
            File file3 = new File(path + "/uploads/car/carSideViewImages");
            File file4 = new File(path + "/uploads/car/carInteriorViewImages");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'carFrontViewImages' created.");
            }

            if (!file2.exists()) {
                file2.mkdirs();
                System.out.println("Directory 'carBackViewImages' created.");
            }

            if (!file3.exists()) {
                file3.mkdirs();
                System.out.println("Directory 'carSideViewImages' created.");
            }

            if (!file4.exists()) {
                file4.mkdirs();
                System.out.println("Directory 'carInteriorViewImages' created.");
            }


            File frontFile = new File(file.getAbsolutePath() + "/" + carDTO.getCarFrontViewImgFilePath().getOriginalFilename());
            if (frontFile.exists()) {
                throw new RuntimeException("File 'carFrontViewImages/" + frontFile.getName() + "' already exists.");
            } else {
                carDTO.getCarFrontViewImgFilePath().transferTo(frontFile);
                car.setCarFrontViewImgFilePath("uploads/car/carFrontViewImages/" + frontFile.getName());
            }

            File backFile = new File(file2.getAbsolutePath() + "/" + carDTO.getCarBackViewImgFilePath().getOriginalFilename());
            if (backFile.exists()) {
                throw new RuntimeException("File 'carBackViewImages/" + backFile.getName() + "' already exists.");
            } else {
                carDTO.getCarBackViewImgFilePath().transferTo(backFile);
                car.setCarBackViewImgFilePath("uploads/car/carBackViewImages/" + backFile.getName());
            }

            File sideFile = new File(file3.getAbsolutePath() + "/" + carDTO.getCarSideViewImgFilePath().getOriginalFilename());
            if (sideFile.exists()) {
                throw new RuntimeException("File 'carSideViewImages/" + sideFile.getName() + "' already exists.");
            } else {
                carDTO.getCarSideViewImgFilePath().transferTo(sideFile);
                car.setCarSideViewImgFilePath("uploads/car/carSideViewImages/" + sideFile.getName());
            }

            File interiorFile = new File(file4.getAbsolutePath() + "/" + carDTO.getCarInteriorViewImgFilePath().getOriginalFilename());
            if (interiorFile.exists()) {
                throw new RuntimeException("File 'carInteriorViewImages/" + interiorFile.getName() + "' already exists.");
            } else {
                carDTO.getCarInteriorViewImgFilePath().transferTo(interiorFile);
                car.setCarInteriorViewImgFilePath("uploads/car/carInteriorViewImages/" + interiorFile.getName());
            }

            System.out.println(car);
            carRepo.save(car);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);

/*        if (!carRepo.existsById(carDTO.getCarId())) {
            throw new RuntimeException("Car ID Not Define.");
        }*/

        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/uploads/car/carFrontViewImages");
            File file2 = new File(path + "/uploads/car/carBackViewImages");
            File file3 = new File(path + "/uploads/car/carSideViewImages");
            File file4 = new File(path + "/uploads/car/carInteriorViewImages");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'carFrontViewImages' created.");
            }

            if (!file2.exists()) {
                file2.mkdirs();
                System.out.println("Directory 'carBackViewImages' created.");
            }

            if (!file3.exists()) {
                file3.mkdirs();
                System.out.println("Directory 'carSideViewImages' created.");
            }

            if (!file4.exists()) {
                file4.mkdirs();
                System.out.println("Directory 'carInteriorViewImages' created.");
            }


            File frontFile = new File(file.getAbsolutePath() + "/" + carDTO.getCarFrontViewImgFilePath().getOriginalFilename());
            if (frontFile.exists()) {
                throw new RuntimeException("File 'carFrontViewImages/" + frontFile.getName() + "' already exists.");
            } else {
                carDTO.getCarFrontViewImgFilePath().transferTo(frontFile);
                car.setCarFrontViewImgFilePath("uploads/car/carFrontViewImages/" + frontFile.getName());
            }

            File backFile = new File(file2.getAbsolutePath() + "/" + carDTO.getCarBackViewImgFilePath().getOriginalFilename());
            if (backFile.exists()) {
                throw new RuntimeException("File 'carBackViewImages/" + backFile.getName() + "' already exists.");
            } else {
                carDTO.getCarBackViewImgFilePath().transferTo(backFile);
                car.setCarBackViewImgFilePath("uploads/car/carBackViewImages/" + backFile.getName());
            }

            File sideFile = new File(file3.getAbsolutePath() + "/" + carDTO.getCarSideViewImgFilePath().getOriginalFilename());
            if (sideFile.exists()) {
                throw new RuntimeException("File 'carSideViewImages/" + sideFile.getName() + "' already exists.");
            } else {
                carDTO.getCarSideViewImgFilePath().transferTo(sideFile);
                car.setCarSideViewImgFilePath("uploads/car/carSideViewImages/" + sideFile.getName());
            }

            File interiorFile = new File(file4.getAbsolutePath() + "/" + carDTO.getCarInteriorViewImgFilePath().getOriginalFilename());
            if (interiorFile.exists()) {
                throw new RuntimeException("File 'carInteriorViewImages/" + interiorFile.getName() + "' already exists.");
            } else {
                carDTO.getCarInteriorViewImgFilePath().transferTo(interiorFile);
                car.setCarInteriorViewImgFilePath("uploads/car/carInteriorViewImages/" + interiorFile.getName());
            }

            System.out.println(car);
            carRepo.save(car);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @Override
    public void deleteCar(String carId, CarDTO carDTO) {
        if (!carRepo.existsById(carDTO.getCarId())) {
            throw new RuntimeException("Wrong Customer ID.Please Enter Correct ID..!");
        }

        carRepo.deleteById(carId);
    }
}
