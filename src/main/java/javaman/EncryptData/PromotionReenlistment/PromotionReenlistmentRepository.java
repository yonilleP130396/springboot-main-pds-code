package javaman.EncryptData.PromotionReenlistment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionReenlistmentRepository extends JpaRepository<PromotionReenlistmentEntity, Long> {

    List<PromotionReenlistmentEntity> findByPersonnelId(Long personnelId);
}
