package com.company.hotel.repositories;

import com.company.hotel.model.Admin;
import com.company.hotel.model.Pengunjung;
import com.company.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findAdminByUsernameAndPassword(String username,String password);

    @Query("FROM Admin")
    public List<Admin> getAdmin();

    @Query(value = "select * from admin where id LIKE %:cariParam% or username LIKE %:cariParam% or password LIKE %:cariParam% ",nativeQuery = true)
    public List<Admin> getAdmin(@Param("cariParam") String cari);

}
