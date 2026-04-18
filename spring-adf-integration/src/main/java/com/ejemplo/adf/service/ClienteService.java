package com.ejemplo.adf.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ejemplo.adf.model.ClienteDTO;

@Service
public class ClienteService {

    private final WebClient adfWebClient;

    public ClienteService(WebClient adfWebClient) {
        this.adfWebClient = adfWebClient;
    }

    public List<ClienteDTO> obtenerClientesDesdeAdf() {
        return adfWebClient
                .get()
                .uri("/clientes")
                .retrieve()
                .bodyToFlux(ClienteDTO.class)
                .collectList()
                .block();
    }
}

