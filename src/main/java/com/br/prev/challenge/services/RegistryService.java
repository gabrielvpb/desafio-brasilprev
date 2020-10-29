package com.br.prev.challenge.services;

import com.br.prev.challenge.controllers.requests.RegistryRequest;
import com.br.prev.challenge.controllers.responses.RegistryResponse;

import java.util.List;

public interface RegistryService {

    public void registerClient(RegistryRequest request);
    public RegistryResponse getClient(Long id);
    public List<RegistryResponse> getClientList();
    public RegistryResponse updateClient(RegistryRequest request);
    public void deleteClient(Long id);
    public RegistryResponse getClientByName(String name);

}
