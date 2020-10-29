package com.br.prev.challenge.controllers.requests;


import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.Column;

@Data
public class RegistryRequest {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String cpf;
    @NotNull
    private String address;
}
