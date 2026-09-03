package javaman.EncryptData.SecurityClearance;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@DynamicUpdate
@Table(name="security_clearance_level_tbl")
public class SecurityClearanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="security_clearance_level_name")
    private String name;

}