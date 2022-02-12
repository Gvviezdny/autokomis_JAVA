package com.company.service.car;

import com.company.model.vehicle.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.company.model.vehicle.PartName.*;

public class CarGenerator {

    private final Random rd = new Random();

    public List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            boolean truck = isTruck();
            cars.add(new Car(generatePrice(), generateBrand(), generateCourse(), generateColor(), generateStandard(), generateCarParts(), truck, generateCargoSpace(truck)));
        }
        return cars;
    }

    private List<CarPart> generateCarParts() {
        return List.of(
                new CarPart(BREAKS, CarPartStatus.values()[new Random().nextInt(CarPartStatus.values().length)]),
                new CarPart(HANDLING, CarPartStatus.values()[new Random().nextInt(CarPartStatus.values().length)]),
                new CarPart(ENGINE, CarPartStatus.values()[new Random().nextInt(CarPartStatus.values().length)]),
                new CarPart(BODY, CarPartStatus.values()[new Random().nextInt(CarPartStatus.values().length)]),
                new CarPart(TRANSMISSION, CarPartStatus.values()[new Random().nextInt(CarPartStatus.values().length)])
        );
    }

    private int generatePrice() {
        return ThreadLocalRandom.current().nextInt(1000, 500000);
    }

    private int generateCourse() {
        return ThreadLocalRandom.current().nextInt(0, 200000);
    }

    private Brand generateBrand() {
        return Brand.values()[new Random().nextInt(Brand.values().length)];
    }

    private Color generateColor() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

    private Standard generateStandard() {
        return Standard.values()[new Random().nextInt(Standard.values().length)];
    }

    private boolean isTruck() {
        return rd.nextBoolean();
    }

    private int generateCargoSpace(boolean isTruck) {
        if (isTruck) {
            return ThreadLocalRandom.current().nextInt(0, 100);
        }
        return 0;
    }
}
