package javaman.EncryptData.BloodType;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BloodTypeService {

    private final BloodTypeRepository repository;

    public List<BloodTypeEntity> getAll() {
        return repository.findAll();
    }

    public Optional<BloodTypeEntity> getById(Long id) {
        return repository.findById(id);
    }

    public BloodTypeEntity save(BloodTypeEntity source) {
        BloodTypeEntity data = new BloodTypeEntity();
        data.setName(source.getName());
        return repository.save(data);
    }

    public BloodTypeEntity update(BloodTypeEntity source) {
        BloodTypeEntity data = repository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Blood Type not found"));
        data.setName(source.getName());
        return repository.save(data);
    }

    // public void delete(Long id) {
    //     repository.deleteById(id);
    // }
}
