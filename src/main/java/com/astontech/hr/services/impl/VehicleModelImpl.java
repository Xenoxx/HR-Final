package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleModelImpl implements VehicleModelService {

    @Autowired
    private VehicleModelRepository vehicleModelRepository;


    @Override
    public List<VehicleModel> listAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findOne(id);
    }

    @Override
    public VehicleModel getVehicleModelByName(String modelName) {
        return vehicleModelRepository.findVehicleModelByName(modelName);
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModels) {
        return vehicleModelRepository.save(vehicleModels);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public void deleteVehicleModel(Integer id) {
        vehicleModelRepository.delete(id);
    }
}
