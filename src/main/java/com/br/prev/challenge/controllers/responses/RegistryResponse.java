package com.br.prev.challenge.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistryResponse {
    private Long id;
    private String name;
    private String cpf;
    private String address;

    private String message;
}
