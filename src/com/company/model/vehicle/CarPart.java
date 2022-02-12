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

    public PartName getPartName() {
        return partName;
    }

    public void setPartName(PartName partName) {
        this.partName = partName;
    }

    public CarPartStatus getCarPartStatus() {
        return carPartStatus;
    }

    public void setCarPartStatus(CarPartStatus carPartStatus) {
        this.carPartStatus = carPartStatus;
    }

    @Override
    public String toString() {
        return "CarPart{" +
                "partName=" + partName +
                ", carPartStatus=" + carPartStatus +
                '}';
    }
}
