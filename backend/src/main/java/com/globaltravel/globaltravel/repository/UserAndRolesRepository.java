package com.globaltravel.globaltravel.repository;

import com.globaltravel.globaltravel.repository.model.UsersAndRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAndRolesRepository extends JpaRepository<UsersAndRoles, Long> {
    List<UsersAndRoles> findByUserId(Long userId);
}
