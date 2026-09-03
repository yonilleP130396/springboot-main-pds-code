package javaman.EncryptData.UsersAccount;


import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@DynamicUpdate
@Table(name = "account_user")
public class myUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String fullName;

    @Column(name = "username", nullable = false,unique= true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin")
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "office", nullable = false)
    private String office;

    @Column(name = "user_level", nullable = false)
    private String role;



}