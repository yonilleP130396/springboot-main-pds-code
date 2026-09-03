package javaman.EncryptData.Gender;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenderService {
    private final GenderRepository genderRepository;

public GenderEntity save(GenderEntity source) {
    GenderEntity data = new GenderEntity();
    data.setName(source.getName());
    return genderRepository.save(data);
}

public List<GenderEntity> getAll() {
    return genderRepository.findAll();
}

public GenderEntity getById(Long id) {
    return genderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Gender not found"));
}

@Transactional
public GenderEntity update(GenderEntity source) {
    GenderEntity data = genderRepository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Gender not found"));
    data.setName(source.getName());
    return genderRepository.save(data);
}

// public void delete(Long id) {
//     genderRepository.deleteById(id);
// }
}
