package com.company.service.car;

import com.company.model.vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class CarBase {

    public static List<Car> cars = new ArrayList<>();
    private final CarGenerator carGenerator = new CarGenerator();

    public void initializeCarBase() {
        cars = carGenerator.generateCars(5);
    }

    public void addRandomCarToCarBase() {
        List<Car> addedCars = carGenerator.generateCars(1);
        CarBase.cars.addAll(addedCars);
    }
}
