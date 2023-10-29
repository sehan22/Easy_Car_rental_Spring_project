package lk.ijse.spring.service;

import lk.ijse.spring.dto.UserDTO;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
}
