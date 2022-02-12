package com.company.service.marketing;

import com.company.model.client.Client;

import java.util.List;

public interface MarketingService {
    List<Client> successfulTransactionPopularization(List<Client> clients);

    List<Client> newspaperPopularization(List<Client> clients);

    List<Client> webAdvertPopularization(List<Client> clients);
}
