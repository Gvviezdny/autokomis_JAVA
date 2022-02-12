package com.company.model.vehicle;

public class CarPart {
    private PartName partName;
    private CarPartStatus carPartStatus;

    public CarPart(PartName partName, CarPartStatus carPartStatus) {
        this.partName = partName;
        this.carPartStatus = carPartStatus;
    }

    public CarPart() {
    }

