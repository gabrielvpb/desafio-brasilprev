package com.br.prev.challenge.services.impl;

import com.br.prev.challenge.controllers.requests.RegistryRequest;
import com.br.prev.challenge.controllers.responses.RegistryResponse;
import com.br.prev.challenge.entities.ClientEntity;
import com.br.prev.challenge.repositories.ClientRepository;
import com.br.prev.challenge.services.RegistryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegistryServiceImpl implements RegistryService {

    private ClientRepository repository;

    @Override
    public void registerClient(RegistryRequest request) {
        repository.save(mapToEntity(request));
    }

    @Override
    public RegistryResponse getClient(Long id) {
        return null;
    }

    @Override
    public List<RegistryResponse> getClientList() {
        return repository.findAll().stream().map(entity -> mapToResponse(entity)).collect(Collectors.toList());
    }

    @Override
    public RegistryResponse updateClient(RegistryRequest request) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }

    private ClientEntity mapToEntity(RegistryRequest request){
        return ClientEntity.builder().name(request.getName()).cpf(request.getCpf()).address(request.getAddress()).build();
    }
    private RegistryResponse mapToResponse(ClientEntity entity){
       return RegistryResponse.builder().id(entity.getId()).name(entity.getName()).address(entity.getAddress()).cpf(entity.getCpf()).build();
    }
}
