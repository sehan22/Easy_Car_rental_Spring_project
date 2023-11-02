package lk.ijse.spring.service;

import lk.ijse.spring.dto.MaintenanceDTO;
import lk.ijse.spring.dto.RentRequestDTO;

import java.util.ArrayList;

public interface RentRequestService {
    ArrayList<RentRequestDTO> getAllRentRequest();
    void saveRentRequests(RentRequestDTO rentRequestDTO);
    void updateRentRequests(RentRequestDTO rentRequestDTO);
}
