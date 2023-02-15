package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleMakeId")
    private Integer id;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleModel> vehicleModelList;

    private String name;

    public VehicleMake(){};
    public VehicleMake(String makeName){
        this.name = makeName;
    };
    public VehicleMake(String makeName, List<VehicleModel> models){
        this.vehicleModelList = models;
    };


    //region    GETTER / SETTERS

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

    public List<VehicleModel> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //endregion

    public String printModelList() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < vehicleModelList.size(); i++) {
            sb.append(vehicleModelList.get(i).getName());
            if (i != vehicleModelList.size()-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }


}
