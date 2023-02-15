package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.ElementService;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        generateElementAndElementTypes();
        generateVehiclesSeedData();

    }


    private void generateVehiclesSeedData(){

        Vehicle vehicle1 = new Vehicle("333");
        Vehicle vehicle2 = new Vehicle("666");
        Vehicle vehicle3 = new Vehicle("999");
        Vehicle vehicle4 = new Vehicle("111");

        VehicleModel tacoma = new VehicleModel("Tacoma");
        VehicleModel rav4 = new VehicleModel("Rav4");
        VehicleModel runner = new VehicleModel("4Runner");

        VehicleMake toyota = new VehicleMake("Toyota");


        List<Vehicle> tacomas = new ArrayList<>();
        tacomas.add(vehicle1);
        tacomas.add(vehicle2);

        List<Vehicle> rav4s = new ArrayList<>();
        rav4s.add(vehicle3);

        List<Vehicle> runners = new ArrayList<>();
        runners.add(vehicle4);

        tacoma.setVehicleList(tacomas);
        rav4.setVehicleList(rav4s);
        runner.setVehicleList(runners);

        List<VehicleModel> toyotaModels = new ArrayList<>();
        toyotaModels.add(tacoma);
        toyotaModels.add(rav4);
        toyotaModels.add(runner);


        toyota.setVehicleModelList(toyotaModels);

        vehicleMakeService.saveVehicleMake(toyota);















    }

    private void generateElementAndElementTypes(){

        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);

        ElementType cupType = new ElementType("Cup");

        List<Element> cupList = new ArrayList<>();
        cupList.add(new Element("Solo"));
        cupList.add(new Element("Crystal"));
        cupList.add(new Element("Coffee"));
        cupList.add(new Element("Ceramic"));
        cupList.add(new Element("Grail"));

        cupType.setElementList(cupList);

        elementTypeService.saveElementType(cupType);

    }

}
