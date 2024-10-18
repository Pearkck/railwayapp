package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.entity.User;
import com.kotchakorn.railwayapp.exceptions.AuthException;
import com.kotchakorn.railwayapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws AuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws AuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null){
            email = email.toLowerCase();
        }
        if(!pattern.matcher(email).matches()){
            throw new AuthException("Invalid email format");
        }
        int count = userRepository.getCountByEmail(email);
        if(count > 0){
            throw new AuthException("Email already in use");
        }
        int userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }

}
