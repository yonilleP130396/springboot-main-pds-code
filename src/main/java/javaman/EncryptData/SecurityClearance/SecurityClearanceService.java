package javaman.EncryptData.SecurityClearance;

import java.util.*;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityClearanceService {

    private final SecurityClearanceRepository securityClearanceRepository;

    public List<SecurityClearanceEntity> getAll() {
        return securityClearanceRepository.findAll();
    }

    public Optional<SecurityClearanceEntity> getById(Long id) {
        return securityClearanceRepository.findById(id);
    }

    public SecurityClearanceEntity save(SecurityClearanceEntity source) {
        SecurityClearanceEntity data = new SecurityClearanceEntity();
        data.setName(source.getName());
        return securityClearanceRepository.save(data);
    }

    public SecurityClearanceEntity update(SecurityClearanceEntity source) {
        SecurityClearanceEntity data = securityClearanceRepository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Registered Office not found"));
        data.setName(source.getName());
        return securityClearanceRepository.save(data);
    }

    // public void delete(Long id) {
    //     securityClearanceRepository.deleteById(id);
    // }
}