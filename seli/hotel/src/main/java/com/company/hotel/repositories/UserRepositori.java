package com.company.hotel.repositories;

import com.company.hotel.model.Admin;
import com.company.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepositori extends JpaRepository<User,Integer> {
    User findUserByUsernameAndPassword(String username, String password);
    @Query("FROM User")
    public List<User> getUser();
}