package UtsJavaApotek.ApotekHerdi.repositories;

import UtsJavaApotek.ApotekHerdi.models.AdminModels;
import UtsJavaApotek.ApotekHerdi.models.BeliModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminModels,Integer> {
    //    HQL (Hibernate Query Language)
    @Query("SELECT u FROM AdminModels u WHERE u.email=:email")
    public AdminModels getAdminByEmail(String email);

    @Query("FROM AdminModels")
    public List<AdminModels> getAdmin();

}
