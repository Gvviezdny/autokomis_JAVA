package com.company.service.client;

import com.company.model.client.Client;

import java.util.List;

import static com.company.service.GameTextService.printInfoClientIncrement;

public class ClientServiceImpl implements ClientService {

    private final ClientGenerator clientGenerator = new ClientGenerator();

    @Override
    public List<Client> incrementClients(List<Client> clients, int incrementSize) {
        List<Client> newClients = clientGenerator.generateClients(incrementSize);
        clients.addAll(newClients);
        printInfoClientIncrement(incrementSize);
        return clients;
    }
}
