package lk.ijse.spring.service;

import lk.ijse.spring.dto.MaintenanceDTO;
import lk.ijse.spring.dto.RentDetailsDTO;
import lk.ijse.spring.dto.RentRequestDTO;
import lk.ijse.spring.entity.RentRequest;

import java.util.ArrayList;
import java.util.List;

public interface RentRequestService {

    public List<RentRequestDTO> getAllRentRequests();
    void saveRentRequests(RentRequestDTO rentRequestDTO);
    void updateRentRequests(RentRequestDTO rentRequestDTO);
}
