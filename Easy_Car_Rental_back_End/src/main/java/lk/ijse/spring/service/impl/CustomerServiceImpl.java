package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.meta.CustomerIngDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<CustomerIngDTO> getAllCustomer() {
        return modelMapper.map(customerRepo.findAll(), new TypeToken<ArrayList<CustomerIngDTO>>() {
        }.getType());
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setUser(new User(customer.getUser().getUserName(), customer.getUser().getUserPassword(), "CUSTOMER", "PENDING_APPROVAL"));


        try {
            String path = System.getProperty("user.dir");
            Path projectPath = Paths.get(path).getParent().getParent().getParent().resolve("/home/sehan-ranaweera/Documents/My GitHub Repositories/Easy_Car_Rental_Spring_Project/Easy_Car_Rental_With_Spring_AAD_Final_Project/Easy_Car_Rental_Front_End");

            File file = new File(projectPath + "/uploads");
            System.out.println("\n\n\n" + projectPath + "\n\n\n");
            file.mkdir();

            System.out.println(customerDTO.getCusNicFrontFilePath());
            System.out.println(customerDTO.getCusDrivingLicenseFrontFilePath());

            customerDTO.getCusNicFrontFilePath().transferTo(new File(file.getAbsolutePath() + "/" + customerDTO.getCusNicFrontFilePath().getOriginalFilename()));
            customerDTO.getCusDrivingLicenseFrontFilePath().transferTo(new File(file.getAbsolutePath() + "/" + customerDTO.getCusDrivingLicenseFrontFilePath().getOriginalFilename()));

            customer.setCusNicFrontFilePath("/uploads/" + customerDTO.getCusNicFrontFilePath().getOriginalFilename());
            customer.setCusDrivingLicenseFrontFilePath("/uploads/" + customerDTO.getCusDrivingLicenseFrontFilePath().getOriginalFilename());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n\n\n\n" + customer);
        customerRepo.save(customer);
/*        if (customerRepo.existsById(customerDTO.getCusId())) {
            throw new RuntimeException("Customer ID Duplicated.");
        } else if (customerRepo.existsById(customerDTO.getUser().getUserName())) {
            throw new RuntimeException("This username is already taken.");
        }

        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/uploads/customer/nicImages");
            File file2 = new File(path + "/uploads/customer/drivingLicenseImages");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'nicImages' created.");
            }

            if (!file2.exists()) {
                file2.mkdirs();
                System.out.println("Directory 'drivingLicenseImages' created.");
            }


            File nicFile = new File(file.getAbsolutePath() + "/" + customerDTO.getCusNicFrontFilePath().getOriginalFilename());
            if (nicFile.exists()) {
                throw new RuntimeException("File 'nicImages/" + nicFile.getName() + "' already exists.");
            } else {
                customerDTO.getCusNicFrontFilePath().transferTo(nicFile);
                customer.setCusNicFrontFilePath("uploads/customer/nicImages/" + nicFile.getName());
            }

            File licenseFile = new File(file2.getAbsolutePath() + "/" + customerDTO.getCusDrivingLicenseFrontFilePath().getOriginalFilename());
            if (licenseFile.exists()) {
                throw new RuntimeException("File 'drivingLicenseImages/" + licenseFile.getName() + "' already exists.");
            } else {
                customerDTO.getCusDrivingLicenseFrontFilePath().transferTo(licenseFile);
                customer.setCusDrivingLicenseFrontFilePath("uploads/customer/drivingLicenseImages/" + licenseFile.getName());
            }

            System.out.println(customer);
            customerRepo.save(customer);
        } catch (IOException e) {
            System.out.println("exception");
//            e.printStackTrace();
            System.out.println(e);
            System.out.println("ihdfbsdif");
        }*/

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String cusId, CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCusId())) {
            throw new RuntimeException("Wrong Customer ID.Please Enter Correct ID..!");
        }

        customerRepo.deleteById(cusId);
    }
}
