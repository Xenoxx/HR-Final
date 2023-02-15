package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehicle> vehicleList;

    private String name;

    public VehicleModel(){}
    public VehicleModel(String modelName){
        this.name = modelName;
    }
    public VehicleModel(String modelName, List<Vehicle> vehicles){
        this.vehicleList = vehicles;
    }


    //region    GETTERS / SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //endregion


    public String printVehicleList() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < vehicleList.size(); i++) {
            sb.append(vehicleList.get(i).getVin());
            if (i != vehicleList.size()-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }


}
