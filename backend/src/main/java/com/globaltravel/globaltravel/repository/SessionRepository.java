package com.globaltravel.globaltravel.repository;

import com.globaltravel.globaltravel.repository.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

}
