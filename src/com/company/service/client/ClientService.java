package com.company.service.client;

import com.company.model.client.Client;

import java.util.List;

public interface ClientService {
    List<Client> incrementClients(List<Client> clients, int incrementSize);
}
