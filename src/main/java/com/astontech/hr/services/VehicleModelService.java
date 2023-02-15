package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleModel;

import java.util.List;

public interface VehicleModelService {

    List<VehicleModel> listAllVehicleModels();

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel getVehicleModelByName(String model);

    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModels);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    void deleteVehicleModel(Integer id);

}
