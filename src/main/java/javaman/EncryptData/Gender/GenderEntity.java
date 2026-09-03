package javaman.EncryptData.Gender;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name= "gender_tbl")
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="gender_name")
    private String name;

}