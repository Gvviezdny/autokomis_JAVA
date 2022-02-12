package com.company.model.mechanic;

import com.company.model.vehicle.Brand;
import com.company.model.vehicle.PartName;

public class FixCostRate {
    private final Brand brand;
    private final PartName partName;
    private final int cost;

    public FixCostRate(Brand brand, PartName partName, int cost) {
        this.brand = brand;
        this.partName = partName;
        this.cost = cost;
    }

    public Brand getBrand() {
        return brand;
    }

    public PartName getPartName() {
        return partName;
    }

    public int getCost() {
        return cost;
    }


