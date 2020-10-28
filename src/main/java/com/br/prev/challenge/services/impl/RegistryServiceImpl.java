package com.br.prev.challenge.services.impl;

import com.br.prev.challenge.controllers.requests.RegistryRequest;
import com.br.prev.challenge.controllers.responses.RegistryResponse;
import com.br.prev.challenge.entities.ClientEntity;
import com.br.prev.challenge.repositories.ClientRepository;
import com.br.prev.challenge.services.RegistryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;
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
       Optional<ClientEntity> entity = repository.findById(id);
       if(entity.isPresent()){
           return mapToResponse(entity.get());
       }else {
           throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Client not found");
       }

    }

    @Override
    public List<RegistryResponse> getClientList() {
        return repository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public RegistryResponse updateClient(RegistryRequest request) {
        return mapToResponse(repository.save(mapToEntity(request)));
    }

    @Override
    public void deleteClient(Long id) {
        Optional<ClientEntity> entity = repository.findById(id);
        if(entity.isPresent()) {
            repository.delete(entity.get());
        }else{
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Client could not be deleted");
        }

    }

    private ClientEntity mapToEntity(RegistryRequest request){
        return ClientEntity.builder().id(request.getId()).name(request.getName()).cpf(request.getCpf()).address(request.getAddress()).build();
    }
    private RegistryResponse mapToResponse(ClientEntity entity){
       return RegistryResponse.builder().id(entity.getId()).name(entity.getName()).address(entity.getAddress()).cpf(entity.getCpf()).build();
    }
}
