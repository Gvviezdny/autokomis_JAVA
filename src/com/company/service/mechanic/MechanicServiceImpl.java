package com.company.service.mechanic;

import com.company.model.mechanic.FixCostRate;
import com.company.model.vehicle.Brand;
import com.company.model.vehicle.PartName;
import com.company.service.payment.PaymentService;
import com.company.service.payment.PaymentServiceImpl;
import com.company.service.GameTextService;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MechanicServiceImpl implements MechanicService {
    private final PaymentService paymentService = new PaymentServiceImpl();
    private final List<FixCostRate> fixCostRates = FixCostTableGenerator.fixCostRates;

    @Override
    public boolean hireMechanicJanusz(Brand brand, PartName part) {
        double costMultiplier = 1.4;
        paymentService.playerPayment(fixByRate(brand, part, costMultiplier));
        return true;
    }

    @Override
    public boolean hireMechanicMarian(Brand brand, PartName part) {
        double costMultiplier = 1;
        int failureChance = 10;
        boolean fixStatus = false;
        if (isFixFailure(failureChance)) {
            GameTextService.printFixFailed(brand, part);
            GameTextService.marianJanuszMessage();
            hireMechanicJanusz(brand, part);
        } else {
            GameTextService.printFixSuccessful(brand, part);
            fixStatus = true;
            paymentService.playerPayment(fixByRate(brand, part, costMultiplier));
        }
        return fixStatus;
    }

    @Override
    public boolean hireMechanicAdrian(Brand brand, PartName part) {
        double costMultiplier = 0.8;
        int failureChance = 20;
        int damageDoneChance = 2;
        boolean fixStatus = false;
        if (isFixFailure(failureChance)) {
            GameTextService.printFixFailed(brand, part);
        } else {
            GameTextService.printFixSuccessful(brand, part);
            fixStatus = true;
            paymentService.playerPayment(fixByRate(brand, part, costMultiplier));
        }

        if (isFixFailure(damageDoneChance)) {
            PartName damagedPart = getRandomPart();
            GameTextService.printDamageDone(brand, damagedPart);
        }
        return fixStatus;
    }

    @Override
    public void washCar() {
        int cost = 40;
        paymentService.playerPayment(cost);
    }

    private int fixByRate(Brand brand, PartName part, double costMultiplier) {
        int cost = 0;
        for (FixCostRate fixCostRate : fixCostRates) {
            if (fixCostRate.getBrand().equals(brand) && fixCostRate.getPartName().equals(part)) {
                cost = fixCostRate.getCost();
            }
        }
        cost = (int) Math.round(cost * costMultiplier);
        return cost;
    }

    private boolean isFixFailure(int chance) {
        return ThreadLocalRandom.current().nextInt(0, 100) <= chance;
    }

    private PartName getRandomPart() {
        return PartName.values()[new Random().nextInt(PartName.values().length)];
    }

}
