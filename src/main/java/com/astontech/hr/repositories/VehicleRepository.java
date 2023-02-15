package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    Vehicle findVehicleById(int id);

    Vehicle findVehicleByVin(String vin);

    @Modifying
    @Query(value = "DELETE FROM VEHICLE_MODEL_VEHICLE_LIST WHERE VEHICLE_LIST_VEHICLE = :id", nativeQuery = true)
    @Transactional
    void deleteVehicleAssociation(@Param("id")int id);
}
