package com.globaltravel.globaltravel.controller;

import com.globaltravel.globaltravel.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping()
    public Object getAllSessions() {
        return sessionRepository.findAll();
    }

}
