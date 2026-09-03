package javaman.EncryptData.FosRating;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FosRatingService {

    private final FosRatingRepository fosRatingRepository;

    public List<FosRatingEntity> getAll() {
        return fosRatingRepository.findAll();
    }

    public List<FosRatingEntity> getOnlyISFRating() {
    return fosRatingRepository.findAllById(List.of(37L, 58L));
}

    public Optional<FosRatingEntity> getById(Long id) {
        return fosRatingRepository.findById(id);
    }

    public FosRatingEntity save(FosRatingEntity source) {
        FosRatingEntity data = fosRatingRepository.findById(source.getId()).orElseThrow(() -> new RuntimeException("FosRating not found"));
        data.setName(source.getName());
        return fosRatingRepository.save(data);
    }

    public FosRatingEntity update(FosRatingEntity source) {
        FosRatingEntity data = new FosRatingEntity();
        data.setId(source.getId());
        data.setName(source.getName());
        return fosRatingRepository.save(data);
    }

    public void delete(Long id) {
        fosRatingRepository.deleteById(id);
    }
}
