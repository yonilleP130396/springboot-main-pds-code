package javaman.EncryptData.AllDataCompiled;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllDataCompiledService {
    private final AllDataCompiledRepository allDataCompiledRepository;

    public List<AllDataCompiledEntity> getAll() {
        return allDataCompiledRepository.findAll();
    }

    public Optional<AllDataCompiledEntity> getById(Long id) {
        return allDataCompiledRepository.findById(id);
    }
    
}

     


