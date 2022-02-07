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
