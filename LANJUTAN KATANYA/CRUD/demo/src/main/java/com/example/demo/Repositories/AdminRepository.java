package com.example.demo.Repositories;

import com.example.demo.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
   Admin findAdminByUsernameAndPassword(String username, String password);

}
