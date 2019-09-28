package com.globaltravel.globaltravel.services;

import com.globaltravel.globaltravel.repository.UserAndRolesRepository;
import com.globaltravel.globaltravel.repository.UserRepository;
import com.globaltravel.globaltravel.repository.model.User;
import com.globaltravel.globaltravel.repository.model.UsersAndRoles;
import com.globaltravel.globaltravel.repository.returnTypes.UserCreationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements BaseUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAndRolesRepository userAndRolesRepository;


    @Override
    public UserCreationStatus createUser(String username, String password, String phone, String eMail, String address, String role) {
        UserCreationStatus userCreationStatus = new UserCreationStatus();

        if(!userRepository.findByUsername(username).isEmpty())  {

            userCreationStatus.setUserCreationStatus(false);
            userCreationStatus.setDescription("User already exists");
            return userCreationStatus;

        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.seteMail(eMail);
        user.setAddress(address);

        userRepository.save(user);

        List<User> users = userRepository.findAll();

        if(users.get(users.size() - 1) != null) {
            userCreationStatus.setUserCreationStatus(true);
            userCreationStatus.setDescription("SUCCESS");

            UsersAndRoles usersAndRoles = new UsersAndRoles();
            usersAndRoles.setRole(role);
            usersAndRoles.setUserId(users.get(users.size() - 1).getUserId());
            userAndRolesRepository.save(usersAndRoles);

            return userCreationStatus;
        } else {
            userCreationStatus.setUserCreationStatus(false);
            return userCreationStatus;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
