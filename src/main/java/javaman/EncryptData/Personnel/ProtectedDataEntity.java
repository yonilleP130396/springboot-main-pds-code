package javaman.EncryptData.Personnel;



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
@Getter
@Setter
@DynamicUpdate
@Table(name = "personal_information_tbl")
public class ProtectedDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT AUTO_INCREMENT")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

     @Column(name = "lastname")
    private String lastname;

     @Column(name = "firstname")
    private String firstname;

     @Column(name = "middlename")
    private String middlename;

     @Column(name = "extension")
    private String extension;

     @Column(name = "afpsn")
    private String afpsn;

    @Column(name = "bos")
    private Long bos;

    @Column(name = "date_enter_military_service")
    private String dateEnterMilitaryService;

     @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "sex")
    private Long sex;

    @Column(name = "source_comms")
    private String sourceComms;

    @Column(name = "class")
    private String classType;

    @Column(name = "fos_rating")
    private Long fosRating;

    @Column(name = "authority")
    private String authority;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "civil_status")
    private Long civilStatus;

    @Column(name = "blood_type")
    private Long bloodType;

    @Column(name="physical_profile")
    private Long physicalProfile;

    @Column(name="ethnicity")
    private String ethnicity;

    @Column(name="religion")
    private String religion;


    @Column(name="security_level")
    private Long securityLevel;


    @Column(name = "is_deleted")
    private int isDeleted;

    @Column(name = "status_definition_category")
    private String statusDefinitionCategory;
}