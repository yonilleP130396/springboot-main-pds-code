package javaman.EncryptData.CivilStatus;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CivilStatusService {

    private final CivilStatusRepository civilStatusRepository;


      // CREATE
    public CivilStatusEntity save(CivilStatusEntity source) {
        CivilStatusEntity data = new CivilStatusEntity();
        data.setName(source.getName());
        return civilStatusRepository.save(data);

    }

    // READ ALL
    public List<CivilStatusEntity> getAll() {
        return civilStatusRepository.findAll();
    }


    // READ BY ID
    public CivilStatusEntity getById(Long id) {
        return civilStatusRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Civil Status not found"));
    }


    // UPDATE
    public CivilStatusEntity update(CivilStatusEntity source) {

        CivilStatusEntity data = civilStatusRepository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Civil Status not found"));
        
        data.setName(source.getName());
        return civilStatusRepository.save(data);
    }


    // // DELETE
    // public void delete(Long id) {
    //     civilStatusRepository.deleteById(id);
    // }
}
