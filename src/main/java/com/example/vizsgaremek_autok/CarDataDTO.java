package com.example.vizsgaremek_autok;

public class CarDataDTO {
    private String givenName;
    private String brand;
    private String model;
    private Number modelYear;
    private String fuelType;
    private Number carPower;
    private String gearType;
    private String color;
    private String chassisType;
    private Number doors;
    private String fuelEconomy;
    private String license_plate;

    public CarDataDTO(String givenName, String brand, String model, Number modelYear, String fuelType, Number carPower, String gearType,
                      String color, String chassisType, Number doors, String fuelEconomy, String license_plate) {
        this.givenName = givenName;
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
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand() {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Number getModelYear() {
        return modelYear;
    }

    public void setModelYear(Number modelYear) {
        this.modelYear = modelYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Number getCarPower() {
        return carPower;
    }

    public void setCarPower(Number carPower) {
        this.carPower = carPower;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChassiType() {
        return chassisType;
    }

    public void setChassiType(String chassiType) {
        this.chassisType = chassiType;
    }

    public Number getDoors() {
        return doors;
    }

    public void setDoors(Number doors) {
        this.doors = doors;
    }

    public String getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(String fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public String getLicence_plate() {
        return license_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.license_plate = licence_plate;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }


}
