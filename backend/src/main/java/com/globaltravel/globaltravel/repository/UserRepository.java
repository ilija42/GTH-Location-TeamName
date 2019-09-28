package com.globaltravel.globaltravel.repository;

import com.globaltravel.globaltravel.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPassword(String password);
    List<User> findByUsername(String username);
}
