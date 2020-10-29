package com.br.prev.challenge.repositories;

import com.br.prev.challenge.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

public Optional<ClientEntity> findByName(String name);
}
