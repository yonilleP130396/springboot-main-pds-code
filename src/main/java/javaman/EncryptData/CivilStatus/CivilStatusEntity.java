package javaman.EncryptData.CivilStatus;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="civil_status_tbl")
public class CivilStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="civil_status_name")
    private String name;

}