package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.dto.meta.CustomerIngDTO;
import lk.ijse.spring.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

public interface CustomerService {
    ArrayList<CustomerIngDTO> getAllCustomer();
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String cusId, CustomerDTO customerDTO);
    CustomerDTO getCustomerByUser_UserName(String userName);
}
