package javaman.EncryptData.AllDataCompiled_V2;

import java.util.List;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllDataCompiledService_V2 {
    private final AllDataCompiledRepository_V2 allDataCompiledRepository;

    public List<AllDataCompiledEntity_V2> getAll() {
        return allDataCompiledRepository.findAll();
    }

    
}

     


