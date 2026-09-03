package javaman.EncryptData.Bos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BosService {
    private final BosRepository bosRepository;


    public List<BosEntity> getAll() {
        return bosRepository.findAll();
    }

    public Optional<BosEntity> getById(Long id) {
        return bosRepository.findById(id);
    }

    public BosEntity save(BosEntity source) {
        BosEntity data = new BosEntity();
        data.setName(source.getName());
        return bosRepository.save(data);
    }

    public BosEntity update(BosEntity source) {
        BosEntity data = bosRepository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Bos Entity not found"));
        
        data.setName(source.getName());
        return bosRepository.save(data);
    }

    // public void delete(Long id) {
    //     bosRepository.deleteById(id);
    // }

}
