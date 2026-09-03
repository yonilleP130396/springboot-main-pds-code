package javaman.EncryptData.Bos;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@DynamicUpdate
@Table(name="bos_tbl")
public class BosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bos_name", nullable = false)
    private String name;


}