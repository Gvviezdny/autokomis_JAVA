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


