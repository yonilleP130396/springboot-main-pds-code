package javaman.EncryptData.CountAllPersonnel;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountOfAllPersonnelService {
    public final CountOfAllPersonnelRepository countOfAllPersonnelRepository;

     public CountOfAllPersonnelEntity getAll() {
        return countOfAllPersonnelRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);
    }

}
