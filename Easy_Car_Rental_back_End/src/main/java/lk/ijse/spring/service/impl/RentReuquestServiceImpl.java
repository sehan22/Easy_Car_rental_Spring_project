package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RentRequestDTO;
import lk.ijse.spring.dto.meta.CarImgDTO;
import lk.ijse.spring.repo.RentRequestRepo;
import lk.ijse.spring.service.RentRequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/*@Service
@Transactional*/
public class RentReuquestServiceImpl {
/*    @Autowired
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

    }*/

/*    @Override
    public void updateRentRequests(RentRequestDTO rentRequestDTO) {

    }*/
}
