package org.neophyte.pertemuan1.Repositories;

import org.neophyte.pertemuan1.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findAdminByUsernameAndPassword(String username,String password);
}
