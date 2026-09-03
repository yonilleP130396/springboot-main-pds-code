package javaman.EncryptData.RegisteredOffice;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RegisteredOfficeService {

    private final RegisteredOfficeRepository repository;

    public List<RegisteredOfficeEntity> getAll() {
        return repository.findAll();
    }

    public RegisteredOfficeEntity getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public RegisteredOfficeEntity save(RegisteredOfficeEntity entity) {
        return repository.save(entity);
    }

    public RegisteredOfficeEntity update(RegisteredOfficeEntity source) {
        RegisteredOfficeEntity data = repository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Registered Office not found"));
        data.setName(source.getName());
        return repository.save(data);
    }

    // public void delete(Long id) {
    //     repository.deleteById(id);
    // }
}