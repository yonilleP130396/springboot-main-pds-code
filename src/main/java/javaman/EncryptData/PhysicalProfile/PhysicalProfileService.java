package javaman.EncryptData.PhysicalProfile;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PhysicalProfileService {

    private final PhysicalProfileRepository physicalProfileRepository;

    public List<PhysicalProfileEntity> getAll() {
        return physicalProfileRepository.findAll();
    }

    public Optional<PhysicalProfileEntity> getById(Long id) {
        return physicalProfileRepository.findById(id);
    }

    public PhysicalProfileEntity save(PhysicalProfileEntity source) {
        PhysicalProfileEntity data = new PhysicalProfileEntity();
        data.setName(source.getName());
        return physicalProfileRepository.save(data);
    }

    public PhysicalProfileEntity update(PhysicalProfileEntity source) {
        PhysicalProfileEntity data =physicalProfileRepository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Physical Profile not found"));
        data.setName(source.getName());
        return physicalProfileRepository.save(data);
    }

    // public void delete(Long id) {
    //     physicalProfileRepository.deleteById(id);
    // }
}
