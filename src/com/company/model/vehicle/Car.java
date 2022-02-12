package com.company.model.vehicle;

import java.util.List;

public class Car {
    private int price;
    private Brand brand;
    private int course;
    private Color color;
    private Standard standard;
    private List<CarPart> carParts;
    private boolean isTruck;
    private int cargoSpace;

    public Car(int price, Brand brand, int course, Color color, Standard standard, List<CarPart> carParts, boolean isTruck, int cargoSpace) {
        this.price = price;
        this.brand = brand;
        this.course = course;
        this.color = color;
        this.standard = standard;
        this.carParts = carParts;
        this.isTruck = isTruck;
        this.cargoSpace = cargoSpace;
    }

    public Car() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public List<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarPart> carParts) {
        this.carParts = carParts;
    }

    public boolean isTruck() {
        return isTruck;
    }

    public void setTruck(boolean truck) {
        isTruck = truck;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", brand=" + brand +
                ", course=" + course +
                ", color=" + color +
                ", standard=" + standard +
                ", carParts=" + carParts +
                ", isTruck=" + isTruck +
                ", cargoSpace=" + cargoSpace +
                '}';
    }
}
