package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

    VehicleModel findVehicleModelById(int id);

    VehicleModel findVehicleModelByName(String modelName);

    List<VehicleModel> findAll();

}
