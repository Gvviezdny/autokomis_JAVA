package com.company;

import com.company.model.Player;
import com.company.model.client.Client;
import com.company.model.vehicle.*;
import com.company.service.GameTextService;
import com.company.service.car.CarBase;
import com.company.service.client.ClientGenerator;
import com.company.service.marketing.MarketingService;
import com.company.service.marketing.MarketingServiceImpl;
import com.company.service.mechanic.FixCostTableGenerator;
import com.company.service.mechanic.FixService;
import com.company.service.payment.PaymentService;
import com.company.service.payment.PaymentServiceImpl;


import java.util.Scanner;

public class Game {

    private final Scanner sc = new Scanner(System.in);
    private final PaymentService paymentService = new PaymentServiceImpl();
    private final MarketingService marketingService = new MarketingServiceImpl();

    public Game() {
        startGame();
    }

    public void startGame() {
        //Start game
        GameTextService.printStartGame();
        Player.money = 1000000;
        GameTextService.printCurrentFunds();

        GameTextService.gameLineBreak();

        //Generate list of initial clients
        ClientGenerator clientGenerator = new ClientGenerator();
        Player.clients = clientGenerator.generateClients(5);
        GameTextService.printClients(Player.clients);

        GameTextService.gameLineBreak();
        GameTextService.printYourCars(Player.cars);
        GameTextService.gameLineBreak();

        //Initialize list of costs per brand and part of cars
        FixCostTableGenerator fixCostTableGenerator = new FixCostTableGenerator();
        fixCostTableGenerator.initFixCostRates();
        GameTextService.printExampleTooltip();
        GameTextService.printFixCostRates(FixCostTableGenerator.fixCostRates, Brand.BMW);

        GameTextService.gameLineBreak();

        //Initialize list of cars for purchase
        CarBase carBase = new CarBase();
        carBase.initializeCarBase();
        GameTextService.printAvailableCarsForPurchase(CarBase.cars);

        GameTextService.gameLineBreak();
        gameAction();
    }

    private void gameAction() {
        GameTextService.controlsTooltip();
        while (sc.hasNextLine()) {
            switch (sc.nextLine()) {
                case "m":
                    GameTextService.printCurrentFunds();
                    break;
                case "c":
                    GameTextService.printAvailableCarsForPurchase(CarBase.cars);
                    break;
                case "v":
                    GameTextService.printYourCars(Player.cars);
                    break;
                case "l":
                    GameTextService.printClients(Player.clients);
                    break;
                case "k":
                    sendCarsToFix();
                    break;
                case "p":
                    purchaseCar();
                    break;
                case "s":
                    sellCar();
                    break;
                case "b":
                    GameTextService.printAdvertNewspaper();
                    marketingService.newspaperPopularization(Player.clients);
                    break;
                case "n":
                    GameTextService.printAdvertWeb();
                    marketingService.webAdvertPopularization(Player.clients);
                    break;
            }
            GameTextService.gameLineBreak();
            GameTextService.controlsTooltip();
        }
    }

    private void purchaseCar() {
        GameTextService.purchaseStatus();
        GameTextService.positionOnListCars();

        int i = Integer.parseInt(sc.nextLine());
        if (CarBase.cars.get(i) != null) {
            Car carToPurchase = CarBase.cars.get(i);
            paymentService.carPurchase(carToPurchase);
        }
    }

    private void sendCarsToFix() {
        FixService fixService = new FixService();

        GameTextService.printYourCars(Player.cars);
        GameTextService.positionOnListCars();

        int i = Integer.parseInt(sc.nextLine());
        if (Player.cars.get(i) != null) {
            fixService.sendCarToFix(Player.cars.get(i));
            fixService.startMechanicServices();
            Player.cars.set(i, fixService.receiveCarFromFix());
        }
    }

    private void sellCar() {
        GameTextService.printSelectClientInfo();
        GameTextService.printClients(Player.clients);

        Client client = new Client();

        int i = Integer.parseInt(sc.nextLine());
        if (Player.clients.get(i) != null) {
            client = Player.clients.get(i);
            GameTextService.printSelectedClient(client);
        }

        GameTextService.printSelectCarSellInfo();
        int j = Integer.parseInt(sc.nextLine());
        if (Player.cars.get(j) != null) {
            Car carForSale = Player.cars.get(j);
            if (isCarFixed(carForSale)) {
                processWithTrade(client, carForSale);
            } else {
                if (isClientSusceptibleToPurchaseUnfixedCar(client, carForSale)) {
                    processWithTrade(client, carForSale);
                }
            }
        }
    }

    private void processWithTrade(Client client, Car carForSale) {
        if (isCarProperForClient(client, carForSale)) {
            Player.cars.remove(carForSale);
            GameTextService.sellSuccessful();
            paymentService.payTax(carForSale.getPrice());
            marketingService.successfulTransactionPopularization(Player.clients);
        } else {
            GameTextService.clientHasDifferentRequirementsMessage();
        }
    }

    private boolean isClientSusceptibleToPurchaseUnfixedCar(Client client, Car carForSale) {
        int partsBroken = 0;
        if (client.getPurchaseSusceptibility() > 90) {
            return true;
        } else if (client.getPurchaseSusceptibility() > 75) {
            for (CarPart carPart : carForSale.getCarParts()) {
                if (carPart.getCarPartStatus().equals(CarPartStatus.DAMAGED)) {
                    partsBroken = partsBroken + 1;
                    if (carPart.getPartName().equals(PartName.HANDLING)) {
                        partsBroken = partsBroken - 1;
                    }
                }
            }
            return partsBroken == 0;
        }
        return false;
    }

    private boolean isCarFixed(Car car) {
        for (CarPart carPart : car.getCarParts()) {
            if (carPart.getCarPartStatus().equals(CarPartStatus.DAMAGED)) {
                return false;
            }
        }
        return true;
    }

    private boolean clientHasMoney(Client client, Car carForSale) {
        return client.getMoney() >= carForSale.getPrice();
    }

    private boolean isCarProperForClient(Client client, Car carForSale) {
        return clientHasMoney(client, carForSale) && isCarTruckStatusProperForClient(client, carForSale) && isBrandMatch(client, carForSale);
    }

    private boolean isCarTruckStatusProperForClient(Client client, Car carForSale) {
        return client.isInterestedInTrucks() == carForSale.isTruck();
    }

    private boolean isBrandMatch(Client client, Car carForSale) {
        for (Brand brand : client.getInterestedBrands()) {
            if (brand.equals(carForSale.getBrand())) {
                return true;
            }
        }
        return false;
    }
}
