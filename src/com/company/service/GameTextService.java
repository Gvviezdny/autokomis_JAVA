package com.company.service;

import com.company.service.car.CarBase;
import com.company.model.Player;
import com.company.model.client.Client;
import com.company.model.mechanic.FixCostRate;
import com.company.model.vehicle.Brand;
import com.company.model.vehicle.Car;
import com.company.model.vehicle.PartName;

import java.util.List;

public class GameTextService {
    public static void printStartGame() {
        System.out.println("STARTING CAR TRADING GAME...");
    }

    public static void printClients(List<Client> clients) {
        for (Client client : clients) {
            System.out.println(client.toString());
        }
    }

    public static void gameLineBreak() {
        System.out.println(" ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }

    public static void printInfoClientIncrement(int count) {
        System.out.println("Amount of clients has increased by : " + count);
    }

    public static void printNotEnoughMoneyInfo() {
        System.out.println("You dont have sufficient funds for this purchase");
    }

    public static void printCurrentFunds() {
        System.out.println("Your current funds: " + Player.money);
    }

    public static void printCurrentFundsAfterPurchase(int spent) {
        System.out.println("You spent " + spent);
        printCurrentFunds();
    }

    public static void printTaxedInfo() {
        System.out.println("You have been taxed from trade");
    }

    public static void printExampleTooltip() {
        System.out.println("Tooltip: Below you can find example list of cost rates for BMW");
    }

    public static void printFixCostRates(List<FixCostRate> fixCostRates, Brand brand) {
        System.out.println("TABLE OF COSTS FOR EACH PART PER CAR BRAND: " + brand);
        for (FixCostRate fixCostRate : fixCostRates) {
            if (fixCostRate.getBrand().equals(brand))
                System.out.println(fixCostRate);
        }
    }

    public static void printFixSuccessful(Brand brand, PartName partName) {
        System.out.println(brand + "`s " + " " + partName + " has been fixed!");
    }

    public static void printFixFailed(Brand brand, PartName partName) {
        System.out.println(brand + "`s " + " " + partName + " fix FAILED!");
    }

    public static void printDamageDone(Brand brand, PartName partName) {
        System.out.println("Mechanic damaged : " + brand + " " + partName);
    }

    public static void printRequestFixMessage(Brand brand, PartName partName) {
        System.out.println("DAMAGED PART FOUND! Would you like to fix : " + brand + " " + partName + " ?");
    }

    public static void printRequestChoiceOfMechanic() {
        System.out.println("Hire one of Three available mechanics: ");
        System.out.println("Press 1 for Janusz: 100% success rate, cost increased by 40%");
        System.out.println("Press 2 for Marian: 90% success rate, normal cost");
        System.out.println("Press 3 for Adrian: 80% success rate, 2% damage chance, cost lowered by 20%");
    }

    public static void printAvailableCarsForPurchase(List<Car> cars) {
        System.out.println("List of cars for purchase: ");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static void printYourCars(List<Car> cars) {
        System.out.println("List of your cars: ");
        if (cars != null && cars.size() > 0) {
            for (Car car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println("You dont own any cars yet");
        }

    }

    public static void printCarPriceIncreased(int carPrice) {
        System.out.println("Car price increased to : " + carPrice);
    }

    public static void marianJanuszMessage() {
        System.out.println("Marian is approaching Janusz for his help");
    }

    public static void januszMessage() {
        System.out.println("You hired Janusz");
    }

    public static void marianMessage() {
        System.out.println("You hired Marian");
    }

    public static void adrianMessage() {
        System.out.println("You hired Adrian");
    }

    public static void controlsTooltip() {
        System.out.println("Press 'm' to view your current funds");
        System.out.println("Press 'l' to view your current clients");
        System.out.println("Press 'v' to view your cars");
        System.out.println("Press 'c' to view cars for purchase");
        System.out.println("Press 'k' to select car for fixing");
        System.out.println("Press 'p' to purchase a car");
        System.out.println("Press 's' to sell a car");
        System.out.println("Press 'b' to put advert in the newspaper");
        System.out.println("Press 'n' to put advert online");
    }

    public static void fixDecisionTooltip() {
        System.out.println("Press Y to fix selected car");
    }

    public static void positionOnListCars() {
        System.out.println("select car position on list");
    }

    public static void purchaseStatus() {
        gameLineBreak();
        printYourCars(Player.cars);
        gameLineBreak();
        printAvailableCarsForPurchase(CarBase.cars);
    }

    public static void purchaseSuccessful() {
        System.out.println("You purchased a car");
    }

    public static void printSelectClientInfo() {
        System.out.println("Select client position on list to pick a client you want to trade with");
    }

    public static void printSelectedClient(Client client) {
        System.out.println("You selected: " + client);
    }

    public static void printSelectCarSellInfo() {
        System.out.println("Select car position on list to this car");
    }

    public static void sellSuccessful() {
        System.out.println("You sold a car");
    }

    public static void clientHasDifferentRequirementsMessage() {
        System.out.println("Client does not like this type of car");
    }

    public static void printAdvertNewspaper() {
        System.out.println("You decided to put an advert in newspaper");
    }

    public static void printAdvertWeb() {
        System.out.println("You decided to put an advert online");
    }
}
