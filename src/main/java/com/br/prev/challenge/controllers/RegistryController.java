package com.br.prev.challenge.controllers;

import com.br.prev.challenge.controllers.requests.RegistryRequest;
import com.br.prev.challenge.controllers.responses.RegistryResponse;
import com.br.prev.challenge.services.RegistryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("registry/client")
public class RegistryController {

    private RegistryService service;

    @PostMapping
    public ResponseEntity<String> registerClient(@RequestBody RegistryRequest request){
        try{
            service.registerClient(request);
            return ResponseEntity.status(HttpStatus.OK).body("Client registered successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<RegistryResponse>> getClients(){
        try{
           return ResponseEntity.status(HttpStatus.OK).body(service.getClientList());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Arrays.asList(RegistryResponse.builder().message(e.getMessage()).build()));
        }
    }

}
