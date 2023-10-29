package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
//        if (customerRepo.existsById(customerDTO.getCusId())) {
//            throw new RuntimeException("Account Registration Failed! Please try again");
//        }
//
//        Customer customer = modelMapper.map(customerDTO, Customer.class);
//
//        customer.setUser(new User(customerDTO.getUser().getUserName(), customerDTO.getUser().getUserPassword(), "Customer", "LOGOUT"));

//        try {
//            String path = System.getProperty("user.dir");
//            System.out.println(path);
//
//            File file = new File(path + "/uploads");
//            System.out.println(file);
//
//            file.mkdir();
//
//            customerDTO.getCusNicFrontFilePath().transferTo(new File(file.getAbsolutePath() + "/" + customerDTO.getCusNicFrontFilePath().get));
//        }


    }

}
