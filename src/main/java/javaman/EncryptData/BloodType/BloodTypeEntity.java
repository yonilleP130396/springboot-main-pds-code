package javaman.EncryptData.BloodType;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name="blood_type_tbl")

public class BloodTypeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT AUTO_INCREMENT")
    private Long id;

    @Column(name="blood_type_name")
    private String name;

}

