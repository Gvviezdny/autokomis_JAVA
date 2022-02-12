package com.company.service.payment;

import com.company.model.Player;
import com.company.model.vehicle.Car;
import com.company.service.car.CarBase;

import static com.company.service.GameTextService.*;

public class PaymentServiceImpl implements PaymentService {
    private final CarBase carBase = new CarBase();

    @Override
    public void playerPayment(int cost) {
        if (Player.money >= cost) {
            Player.money -= cost;
            printCurrentFundsAfterPurchase(cost);
        } else {
            printNotEnoughMoneyInfo();
        }
    }

    @Override
    public void payTax(int cost) {
        printTaxedInfo();
        float tax = Math.round(cost * 0.02);
        playerPayment((int) tax);
    }

    @Override
    public void carPurchase(Car car) {
        int cost = car.getPrice();
        if (Player.money >= cost) {
            Player.money -= cost;
            printCurrentFundsAfterPurchase(cost);
            Player.cars.add(car);
            CarBase.cars.remove(car);
            purchaseSuccessful();

            payTax(cost);

            carBase.addRandomCarToCarBase();
        } else {
            printNotEnoughMoneyInfo();
        }
    }


}
