package javaman.EncryptData.AllDataCompiled;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "vw_list_personal_information")
@Immutable
@Getter
@Setter
public class AllDataCompiledEntity {

  @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "rank_code")
    private String rankCode;

    @Column(name = "user_id", length = 255)
    private String userId;

    @Column(name = "rank")
    private String rank;

    @Column(name = "office", nullable = false, length = 255)
    private String office;

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

    @Column(name = "current_assignment")
    private String presentAssignment;

    @Column(name = "date_current_assignment")
    private String startDateAssignment;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "bos")
    private String bos;

    @Column(name = "gender")
    private String gender;

    @Column(name = "source_comms")
    private String sourceComms;

    @Column(name = "class")
    private String personnelClass;

    @Column(name = "fos_rating", nullable = false)
    private String fosRating;

    @Column(name = "authority")
    private String authority;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "service_provider", length = 9)
    private String serviceProvider;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "civil_status")
    private String civilStatus;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "physical_profile")
    private String physicalProfile;

    @Column(name = "ethnicity")
    private String ethnicity;


    @Column(name = "religion")
    private String religion;


    @Column(name = "security_level", nullable = false)
    private String securityLevel;

    @Column(name = "field_duty", length = 77)
    private String fieldDuty;

    @Column(name = "sea_duty", length = 77)
    private String seaDuty;

    @Column(name = "combat_duty", length = 77)
    private String combatDuty;

    @Column(name = "garrison_duty", length = 77)
    private String garrisonDuty;

    @Column(name = "schooling_remarks", length = 18)
    private String schoolingRemarks;

    @Column(name = "updated_reenlistment")
    private String updatedReenlistment;

    @Column(name = "updated_promotion")
    private String updatedPromotion;

    @Column(name = "start_submission_promotion", length = 26)
    private String startSubmissionPromotion;

    @Column(name = "time_in_grade", length = 26)
    private String timeInGrade;

    @Column(name = "tenure_in_grade", length = 26)
    private String tenureInGrade;

    @Column(name = "for_promex_exam", length = 26)
    private String forPromexExam;

    @Column(name = "date_enter_military_service")
    private String dateEnterMilitaryService;

    @Column(name = "etad_ete")
    private String etadEte;

    @Column(name = "compulsory")
    private LocalDate compulsory;

    
}

