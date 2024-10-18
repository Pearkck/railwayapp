package com.kotchakorn.railwayapp.service;

import com.kotchakorn.railwayapp.entity.User;
import com.kotchakorn.railwayapp.exceptions.AuthException;

public interface UserService {
    User validateUser(String email, String password) throws AuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws AuthException;
}
