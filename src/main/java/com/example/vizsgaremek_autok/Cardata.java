package com.example.vizsgaremek_autok;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cardata {
    public Cardata(Car car) {
        this.car = car;
    }

    public Cardata() {
    }

    @JsonProperty("cars")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private Car car;
}
