package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.MaintenanceDTO;
import lk.ijse.spring.dto.RentRequestDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.RentRequest;
import lk.ijse.spring.repo.RentRequestRepo;
import lk.ijse.spring.service.RentRequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class RentDetailsServiceImpl implements RentRequestService {
    @Autowired
    RentRequestRepo rentRequestRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<RentRequestDTO> getAllRentRequest() {
        return modelMapper.map(rentRequestRepo.findAll(), new TypeToken<ArrayList<RentRequestDTO>>() {
        }.getType());
    }

    @Override
    public void saveRentRequests(RentRequestDTO rentRequestDTO) {
        RentRequest rentRequest = modelMapper.map(rentRequestDTO, RentRequest.class);
        rentRequestRepo.save(rentRequest);
    }

    @Override
    public void updateRentRequests(RentRequestDTO rentRequestDTO) {

    }
}
