package com.globaltravel.globaltravel.repository;

import com.globaltravel.globaltravel.repository.model.FlightAndUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightAndUsersRepository extends JpaRepository<FlightAndUsers, Long> {
    List<FlightAndUsers> findAllByUserId(Long userId);
}
