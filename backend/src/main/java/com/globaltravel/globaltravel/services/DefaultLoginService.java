package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.SessionRepository;
import com.globaltravel.globaltravel.repository.UserAndRolesRepository;
import com.globaltravel.globaltravel.repository.UserRepository;
import com.globaltravel.globaltravel.repository.model.Session;
import com.globaltravel.globaltravel.repository.model.User;
import com.globaltravel.globaltravel.repository.returnTypes.LoginStatus;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultLoginService implements BaseLoginService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAndRolesRepository userAndRolesRepository;

    @Override
    public LoginStatus login(String username, String password) {

        String hashedPass = DigestUtils.sha256Hex(password);

        List<User> users = userRepository.findByPassword(hashedPass);

        LoginStatus loginStatus = new LoginStatus();
        loginStatus.setLoginStatus(false);


        for(User u: users) {
            if(u.getUsername().equals(username)) {
                loginStatus.setLoginStatus(true);

                Session session = new Session();
                session.setToken(generateToken());

                Date tokenExpirationDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(tokenExpirationDate);
                calendar.add(Calendar.DATE, 1);
                tokenExpirationDate = calendar.getTime();

                session.setLastsUntil(tokenExpirationDate);
                session.setRole(userAndRolesRepository.findByUserId(u.getUserId()).get(0).getRole());
                session.setUserId(u.getUserId());

                sessionRepository.save(session);

                loginStatus.setToken(session.getToken());

                return loginStatus;
            }
        }

        return loginStatus;
    }

    private String generateToken() {
        int len = 128;
        String generatedToken;

        while(true) {
            generatedToken = RandomStringUtils.random(len, true, true);
            Optional<Session> usedToken = sessionRepository.findById(generatedToken);

            if(!usedToken.isPresent())
                break;
        }

        return generatedToken;
    }


}
