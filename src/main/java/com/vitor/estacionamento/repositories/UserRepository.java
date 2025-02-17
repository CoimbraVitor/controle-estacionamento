package com.vitor.estacionamento.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.estacionamento.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String login);

}
