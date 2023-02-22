package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleMakeImpl implements VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;


    @Override
    public Iterable<VehicleMake> listAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public VehicleMake getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findOne(id);
    }

    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public void deleteVehicleMake(Integer id) {
        vehicleMakeRepository.delete(id);
    }

    @Override
    public VehicleMake findVehicleMakeByModel(String name) {
        return vehicleMakeRepository.findVehicleMakeByVehicleModelId(name);
    }

    @Override
    public VehicleMake findVehicleMakeByName(String name) {
        return vehicleMakeRepository.findVehicleMakeByName(name);
    }


    @Override
    public VehicleMake updateVehicleMake(VehicleMake vehicleMake, String newModel) {

        if(!newModel.equals("")) {
            if(vehicleMake.getVehicleModelList() == null) {
                List<VehicleModel> modelList = new ArrayList<VehicleModel>();
                modelList.add(new VehicleModel(newModel));
                vehicleMake.setVehicleModelList(modelList);
            } else {
                boolean modelExists = false;
                for (VehicleModel modelX : vehicleMake.getVehicleModelList()) {
                    if (modelX.getName().equals(newModel)) {
                        modelExists = true;
                        break;
                    }
                }
                if (!modelExists) {
                    vehicleMake.getVehicleModelList().add(new VehicleModel(newModel));
                }
            }
        }
        //  iterate through the list of elements
        boolean isDeleted = false;
        for (int i = 0; i < vehicleMake.getVehicleModelList().size(); i++) {
            //check to see if element name is empty or blank
            if(vehicleMake.getVehicleModelList().get(i).getName().equals("")){
                //element name is blank remove it for the list
                isDeleted = true;
                VehicleModel deletedModel = vehicleMake.getVehicleModelList().remove(i);
                saveVehicleMake(vehicleMake);
                vehicleModelRepository.delete(deletedModel.getId());
            }
        }
        if (!isDeleted){
            saveVehicleMake(vehicleMake);
        }

        return vehicleMake;
    }

}
