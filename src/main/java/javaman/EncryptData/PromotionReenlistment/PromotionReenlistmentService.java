package javaman.EncryptData.PromotionReenlistment;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PromotionReenlistmentService {

    private final PromotionReenlistmentRepository repository;

    public List<PromotionReenlistmentEntity> getAll() {
        return repository.findAll();
    }

    public List<PromotionReenlistmentEntity> getByPersonnelId(Long personnelId) {
    return repository.findByPersonnelId(personnelId);
    }
    
}




