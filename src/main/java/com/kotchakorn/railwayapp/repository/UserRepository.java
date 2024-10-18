package com.kotchakorn.railwayapp.repository;

import com.kotchakorn.railwayapp.entity.User;
import com.kotchakorn.railwayapp.exceptions.AuthException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository {
    int create(String firstName,String lastName, String email, String password) throws AuthException;

    User findByEmailAndPassword(String email, String password) throws AuthException;

    int getCountByEmail(String email);

    User findById(int userId);
}
