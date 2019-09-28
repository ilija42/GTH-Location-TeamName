package com.globaltravel.globaltravel.repository.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Session")
public class Session {

    @Id
    @Column(length = 128)
    private String token;

    private Date lastsUntil;

    private String role;

    private Long userId;

    public Session() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastsUntil() {
        return lastsUntil;
    }

    public void setLastsUntil(Date lastsUntil) {
        this.lastsUntil = lastsUntil;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
