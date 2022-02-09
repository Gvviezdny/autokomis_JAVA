package com.company.model.client;

import com.company.model.vehicle.Brand;

import java.util.List;

public class Client {
    private boolean isInterestedInTrucks;
    private int money;
    private List<Brand> interestedBrands;
    private int purchaseSusceptibility;

    public boolean isInterestedInTrucks() {
        return isInterestedInTrucks;
    }

    public void setInterestedInTrucks(boolean interestedInTrucks) {
        isInterestedInTrucks = interestedInTrucks;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Brand> getInterestedBrands() {
        return interestedBrands;
    }

    public void setInterestedBrands(List<Brand> interestedBrands) {
        this.interestedBrands = interestedBrands;
    }

    public int getPurchaseSusceptibility() {
        return purchaseSusceptibility;
    }

    public void setPurchaseSusceptibility(int purchaseSusceptibility) {
        this.purchaseSusceptibility = purchaseSusceptibility;
    }

    @Override
    public String toString() {
        return "Client{" +
                "isInterestedInTrucks=" + isInterestedInTrucks +
                ", money=" + money +
                ", interestedBrands=" + interestedBrands +
                ", purchaseSusceptibility=" + purchaseSusceptibility +
                '}';
    }
}
