package javaman.EncryptData.AllDataCompiled_V2;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "vw_list_personal_information_v2")
@Immutable
@Getter
@Setter
public class AllDataCompiledEntity_V2 {

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

    @Column(name = "bos")
    private String bos;



    
}

