package com.company.service.client;

import com.company.model.client.Client;
import com.company.model.vehicle.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ClientGenerator {
    private final Random rd = new Random();

    public int randomizeClientIncrement() {
        return ThreadLocalRandom.current().nextInt(2, 5);
    }

    public List<Client> generateClients(int clientCount) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < clientCount; i++) {
            clients.add(
                    buildClient(
                            randomizeClientInterestInTrucks(),
                            randomizeClientMoney(),
                            randomizeClientInterestInBrands(),
                            randomizePurchaseSusceptibility())
            );
        }

        return clients;
    }

    private Client buildClient(boolean interestedInTrucks, int money, List<Brand> brands, int purchaseSusceptibility) {
        Client client = new Client();
        client.setInterestedInTrucks(interestedInTrucks);
        client.setMoney(money);
        client.setInterestedBrands(brands);
        client.setPurchaseSusceptibility(purchaseSusceptibility);
        return client;
    }

    private boolean randomizeClientInterestInTrucks() {
        return rd.nextBoolean();
    }

    private int randomizeClientMoney() {
        return ThreadLocalRandom.current().nextInt(1000, 500000 + 1);
    }

    private List<Brand> randomizeClientInterestInBrands() {
        Brand firstBrandOfInterest = getRandomBrand();
        Brand secondBrandOfInterest = getRandomBrand();
        while (firstBrandOfInterest == secondBrandOfInterest) {
            secondBrandOfInterest = getRandomBrand();
        }
        return List.of(firstBrandOfInterest, secondBrandOfInterest);
    }

    private Brand getRandomBrand() {
        return Brand.values()[new Random().nextInt(Brand.values().length)];
    }

    private int randomizePurchaseSusceptibility() {
        return ThreadLocalRandom.current().nextInt(0, 99 + 1);
    }
}
