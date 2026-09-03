package javaman.EncryptData.PromotionReenlistment;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.*;

@Entity
@Table(name = "vw_personnel_promotion_reenlistment")
@Immutable
@Getter
@Setter
public class PromotionReenlistmentEntity {

    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "personnel_id")
    private Long personnelId;

    @Column(name = "afpsn")
    private String afpsn;

    @Column(name = "transaction_type", nullable = false, length = 13)
    private String transactionType;

    @Column(name = "category")
    private String category;

    @Column(name = "transaction_date")
    private String transactionDate;

    @Column(name = "special_order")
    private String specialOrder;

    @Column(name = "permanent_rank")
    private String permanentRank;

}
