package lk.ijse.spring.service;

import lk.ijse.spring.dto.MaintenanceDTO;

import java.util.ArrayList;

public interface MaintenanceService {
    ArrayList<MaintenanceDTO> getAllMaintenances();
    void saveMaintenance(MaintenanceDTO maintenanceDTO);
    void updateMaintenance(MaintenanceDTO maintenanceDTO);
    void deleteMaintenance(String carId, MaintenanceDTO maintenanceDTO);
}
