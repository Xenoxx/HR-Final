package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {

    VehicleMake findVehicleMakeById(int id);

    VehicleMake findVehicleMakeByName(String name);

    @Query("SELECT make FROM VehicleMake make JOIN make.vehicleModelList list WHERE list.name = ?1")
    VehicleMake findVehicleMakeByVehicleModelId(String name);
}
