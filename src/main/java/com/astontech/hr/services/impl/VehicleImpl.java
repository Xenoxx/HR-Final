package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Iterable<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleRepository.delete(id);
    }

    @Override
    public Vehicle findVehicleByVin(String vin){
        return vehicleRepository.findVehicleByVin(vin);
    }

    @Override
    public String findVehicleModelByVehicleId(Integer id) {
        return vehicleRepository.findVehicleModelByVehicleId(id);
    }

    @Override
    public String findVehicleMakeByVehicleId(Integer id) {
        return vehicleRepository.findVehicleMakeByVehicleId(id);
    }
}
