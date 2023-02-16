package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Vehicle")
    private Integer id;

    @Version
    private Integer version;

    private String color;
    private String vin;
    private int year;
    private int price;
    private String purchaseDate;
    private Boolean sold;
    private String licensePlate;


    public Vehicle(){}
    public Vehicle(String vin){
        this.vin = vin;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


    //endregion


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", version=" + version +
                ", color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", sold=" + sold +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }


}
