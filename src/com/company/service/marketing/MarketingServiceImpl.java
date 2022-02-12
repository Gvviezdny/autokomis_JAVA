package com.company.service.marketing;

import com.company.model.client.Client;
import com.company.service.client.ClientGenerator;
import com.company.service.client.ClientService;
import com.company.service.client.ClientServiceImpl;
import com.company.service.payment.PaymentService;
import com.company.service.payment.PaymentServiceImpl;

import java.util.List;

public class MarketingServiceImpl implements MarketingService {

    private final ClientService clientService = new ClientServiceImpl();
    private final ClientGenerator clientGenerator = new ClientGenerator();
    private final PaymentService paymentService = new PaymentServiceImpl();

    @Override
    public List<Client> successfulTransactionPopularization(List<Client> clients) {
        return clientService.incrementClients(clients, 2);
    }

    @Override
    public List<Client> newspaperPopularization(List<Client> clients) {
        int cost = 500;
        paymentService.playerPayment(cost);
        return clientService.incrementClients(clients, clientGenerator.randomizeClientIncrement());
    }

    @Override
    public List<Client> webAdvertPopularization(List<Client> clients) {
        int cost = 100;
        paymentService.playerPayment(cost);
        return clientService.incrementClients(clients, 1);
    }
}
