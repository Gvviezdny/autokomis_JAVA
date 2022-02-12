package com.company.service.mechanic;

import com.company.model.vehicle.Car;
import com.company.model.vehicle.CarPart;
import com.company.model.vehicle.CarPartStatus;
import com.company.model.vehicle.PartName;
import com.company.service.GameTextService;

import java.util.List;
import java.util.Scanner;

import static com.company.model.vehicle.PartName.*;

public class FixService {
    private Car car;
    private final MechanicService mechanicService = new MechanicServiceImpl();

    public void sendCarToFix(Car car) {
        this.car = car;
    }

    public void startMechanicServices() {
        examineCar();
        washCar();
    }

    public Car receiveCarFromFix() {
        return this.car;
    }

    private void hireMechanic(int choice, CarPart carPart) {
        boolean isFixed = false;
        PartName partName = carPart.getPartName();
        switch (choice) {
            case 1:
                GameTextService.januszMessage();
                isFixed = mechanicService.hireMechanicJanusz(car.getBrand(), partName);
                break;
            case 2:
                GameTextService.marianMessage();
                isFixed = mechanicService.hireMechanicMarian(car.getBrand(), partName);
                break;
            case 3:
                GameTextService.adrianMessage();
                isFixed = mechanicService.hireMechanicAdrian(car.getBrand(), partName);
                break;
        }

        changePartToFixedStatus(isFixed, partName);
        changeFixedCarPrice(isFixed, partName);
    }

    private void examineCar() {
        List<CarPart> carParts = car.getCarParts();
        for (CarPart carPart : carParts) {
            if (carPart.getCarPartStatus().equals(CarPartStatus.DAMAGED)) {
                requestCarPartFix(carPart);
            }
        }
    }

    private void washCar() {
        mechanicService.washCar();
    }

    private void requestCarPartFix(CarPart carPart) {
        GameTextService.printRequestFixMessage(car.getBrand(), carPart.getPartName());
        GameTextService.fixDecisionTooltip();
        Scanner sc = new Scanner(System.in);
        String fixDecision = sc.nextLine();
        if (fixDecision.equals("y") || fixDecision.equals("Y")) {
            GameTextService.printRequestChoiceOfMechanic();
            String mechanicChoice = sc.nextLine();
            if (validateMechanicInput(mechanicChoice))
                hireMechanic(Integer.parseInt(mechanicChoice), carPart);
        }

    }

    private boolean validateMechanicInput(String mechanic) {
        return mechanic.equals("1") || mechanic.equals("2") || mechanic.equals("3");
    }

    private void changeFixedCarPrice(boolean isFixed, PartName partName) {
        double multiplier = 0;
        if (isFixed) {
            if (partName.equals(BREAKS)) {
                multiplier = 1.1;
            } else if (partName.equals(HANDLING)) {
                multiplier = 1.2;
            } else if (partName.equals(ENGINE)) {
                multiplier = 2;
            } else if (partName.equals(BODY)) {
                multiplier = 1.5;
            } else if (partName.equals(TRANSMISSION)) {
                multiplier = 1.5;
            }
            float fixedCarPrice = Math.round(car.getPrice() * multiplier);
            car.setPrice((int) fixedCarPrice);
            GameTextService.printCarPriceIncreased(car.getPrice());


        }
    }

    private void changePartToFixedStatus(boolean isFixed, PartName partName) {
        if (isFixed) {
            for (CarPart carPart : car.getCarParts()) {
                if (carPart.getPartName().equals(partName) && carPart.getCarPartStatus().equals(CarPartStatus.DAMAGED)) {
                    carPart.setCarPartStatus(CarPartStatus.EFFICIENT);
                }
            }
        }
    }

}
