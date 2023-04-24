package com.example.vizsgaremek_autok;

public class CarDataDTO {
private Number carId;
private String brand;
private String model;
private Number modelYear;
private String fuelType;
private Number carPower;
private String gearType;
private String color;
private String chassiType;
private Number doors;
private String fuelEconomy;
private String licence_plate;
private String givenName;


    public CarDataDTO(Number carId, String brand, String model,Number modelYear,String fuelType,Number carPower,String gearType,
                      String color, String chassiType, Number doors, String fuelEconomy, String licence_plate,String givenName){
        this.carId=carId;
        this.brand=brand;
        this.model=model;
        this.modelYear=modelYear;
        this.fuelType=fuelType;
        this.carPower=carPower;
        this.gearType=gearType;
        this.color=color;
        this.chassiType=chassiType;
        this.doors=doors;
        this.fuelEconomy=fuelEconomy;
        this.licence_plate=licence_plate;
        this.givenName=givenName;

    }

    public Number getCarId(){return carId;}
    public void setCarId(Number carId){this.carId=carId;}
    public String getBrand(){return brand;}
    public void setBrand(){this.brand = brand;}
    public String getModel(){return model;}
    public void setModel(String model){this.model=model;}
    public Number getModelYear(){return modelYear;}
    public void setModelYear(Number modelYear){this.modelYear=modelYear;}
    public String getFuelType(){return fuelType;}
    public void setFuelType(String fuelType){this.fuelType=fuelType;}
    public Number getCarPower(){return carPower;}
    public void setCarPower(Number carPower){this.carPower=carPower;}
    public String getGearType(){return gearType;}
    public void setGearType(String gearType){this.gearType=gearType;}
    public String getColor(){return color;}
    public void setColor(String color){this.color=color;}
    public String getChassiType(){return chassiType;}
    public void setChassiType(String chassiType){this.chassiType=chassiType;}
    public Number getDoors(){return doors;}
    public void setDoors(Number doors){this.doors=doors;}
    public String getFuelEconomy(){return fuelEconomy;}
    public void setFuelEconomy(String fuelEconomy){this.fuelEconomy=fuelEconomy;}
    public String getLicence_plate(){return licence_plate;}
    public void setLicence_plate(String licence_plate){this.licence_plate=licence_plate;}
    public String getGivenName(){return givenName;}
    public void setGivenName(String givenName){this.givenName=givenName;}



}
