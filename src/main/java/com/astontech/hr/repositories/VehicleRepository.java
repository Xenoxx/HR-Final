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


    @Query(value = "SELECT c.NAME\n" +
            "FROM VEHICLE a\n" +
            "INNER JOIN VEHICLE_MODEL_VEHICLE_LIST b ON a.VEHICLE = b.VEHICLE_LIST_VEHICLE\n" +
            "INNER JOIN VEHICLE_MODEL c ON b.VEHICLE_MODEL_VEHICLEMODELID = c.VEHICLE_MODEL_ID\n" +
            "WHERE a.VEHICLE = :id", nativeQuery = true)
    @Transactional
    String findVehicleModelByVehicleId(@Param("id")int id);

    @Query(value = "SELECT e.NAME\n" +
            "FROM VEHICLE a\n" +
            "INNER JOIN VEHICLE_MODEL_VEHICLE_LIST b ON a.VEHICLE = b.VEHICLE_LIST_VEHICLE\n" +
            "INNER JOIN VEHICLE_MODEL c ON b.VEHICLE_MODEL_VEHICLEMODELID = c.VEHICLE_MODEL_ID\n" +
            "INNER JOIN VEHICLE_MAKE_VEHICLE_MODEL_LIST d ON c.VEHICLE_MODEL_ID = d.VEHICLE_MODEL_LIST_VEHICLEMODELID\n" +
            "INNER JOIN VEHICLE_MAKE e ON d.VEHICLE_MAKE_VEHICLEMAKEID = e.VEHICLE_MAKE_ID\n" +
            "WHERE a.VEHICLE = :id", nativeQuery = true)
    @Transactional
    String findVehicleMakeByVehicleId(@Param("id")int id);




}
