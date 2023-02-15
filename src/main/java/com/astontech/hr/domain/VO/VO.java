package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

import java.util.ArrayList;
import java.util.List;

public class VO {

    Vehicle vehicle = new Vehicle();
    VehicleModel vehicleModel = new VehicleModel();
    VehicleMake vehicleMake = new VehicleMake();

    public VO() {
    }

    public List<VehicleModel> splitNewModelsIntoArray() {
        String[] modelNames = this.getVehicleModel().getName().split("\\r?\\n");
        if (this.vehicleMake.getVehicleModelList() == null) {
            this.vehicleMake.setVehicleModelList(new ArrayList<>());
        }
        for (String name : modelNames) {
            VehicleModel newModel = new VehicleModel(name);
            this.vehicleMake.getVehicleModelList().add(newModel);
        }
        return this.vehicleMake.getVehicleModelList();
    }



    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
}
