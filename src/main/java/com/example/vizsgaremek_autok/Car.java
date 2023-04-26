package com.example.vizsgaremek_autok;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private int carId;
    private String brand;
    private String model;
    private int modelYear;
    private String fuelType;
    private int carPower;
    private String gearType;
    private String color;
    private String chassisType;
    private int doors;
    private String fuelEconomy;
    private String license_plate;
    private String givenName;

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", fuelType='" + fuelType + '\'' +
                ", carPower=" + carPower +
                ", gearType='" + gearType + '\'' +
                ", color='" + color + '\'' +
                ", chassisType='" + chassisType + '\'' +
                ", doors=" + doors +
                ", fuelEconomy='" + fuelEconomy + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", givenName='" + givenName + '\'' +
                '}';
    }


    public Car() {
    }


    public Car(int carId, String brand, String model, int modelYear, String fuelType, int carPower, String gearType, String color, String chassisType, int doors, String fuelEconomy, String license_plate, String givenName) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.modelYear = modelYear;
        this.fuelType = fuelType;
        this.carPower = carPower;
        this.gearType = gearType;
        this.color = color;
        this.chassisType = chassisType;
        this.doors = doors;
        this.fuelEconomy = fuelEconomy;
        this.license_plate = license_plate;
        this.givenName= givenName;
    }

    @JsonProperty("carId")
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("modelYear")
    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    @JsonProperty("fuelType")
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @JsonProperty("carPower")
    public int getCarPower() {
        return carPower;
    }

    public void setCarPower(int carPower) {
        this.carPower = carPower;
    }

    @JsonProperty("gearType")
    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("chassisType")
    public String getChassisType() {
        return chassisType;
    }

    public void setChassisType(String chassisType) {
        this.chassisType = chassisType;
    }

    @JsonProperty("doors")
    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @JsonProperty("fuelEconomy")
    public String getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(String fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    @JsonProperty("license_plate")
    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    @JsonProperty("givenName")
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

}


