package javaman.EncryptData.ActivityLogs;

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
@Table(name="activity_log")
public class ActivityLogsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user", nullable = false, length = 100)
    private String user;

    @Column(name = "action", nullable = false, length = 100)
    private String action;

    @Column(name = "entity_id")
    private Long entityId;
}
