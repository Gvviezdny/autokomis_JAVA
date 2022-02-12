package com.company.service.payment;

import com.company.model.vehicle.Car;

public interface PaymentService {
    void playerPayment(int cost);

    void payTax(int cost);

    void carPurchase(Car car);
}
