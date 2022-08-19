package UtsJavaApotek.ApotekHerdi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

//From JPA / Java Persistance
@Entity
@Table(name = "table_adm")

//From Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminModels implements Serializable {
    //From JPA
    @Id  //Menandakan Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoIncrement
    @Column(name = "id_adm",nullable = false, unique = true)
    private Integer id_adm;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    public Integer getId_adm() {
        return id_adm;
    }

    public void setId_adm(Integer id_adm) {
        this.id_adm = id_adm;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
