package javaman.EncryptData.Personnel;

// import java.util.Comparator;
// import java.util.LinkedHashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;
// import java.util.TreeMap;
// import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProtectedDataService {

    
     private final ProtectedDataRepository protecteddataRepository;
    // private final ChangeFosRepository changeFosRepository;

 
    public ProtectedDataEntity getById(Long id) {
        return protecteddataRepository.findById(id).orElse(null);
    }

   
     public ProtectedDataEntity saveProtectedData(ProtectedDataEntity source) {
        ProtectedDataEntity data = new ProtectedDataEntity();
        data.setUserId(source.getUserId());
        data.setLastname(source.getLastname());
        data.setFirstname(source.getFirstname());
        data.setMiddlename(source.getMiddlename());
        data.setExtension(source.getExtension());
        data.setAfpsn(source.getAfpsn());
        data.setBos(source.getBos());
        data.setDateEnterMilitaryService( source.getDateEnterMilitaryService());
        data.setBirthdate(source.getBirthdate());
        data.setSex(source.getSex());
        data.setSourceComms(source.getSourceComms());
        data.setClassType(source.getClassType());
        data.setFosRating(source.getFosRating());
        data.setAuthority(source.getAuthority());
        data.setMobileNumber(source.getMobileNumber());
        data.setEmailAddress(source.getEmailAddress());
        data.setCivilStatus(source.getCivilStatus());
        data.setBloodType(source.getBloodType());
        data.setPhysicalProfile(source.getPhysicalProfile());
        data.setEthnicity(source.getEthnicity());
        data.setReligion(source.getReligion());
        data.setSecurityLevel(source.getSecurityLevel());
        data.setStatusDefinitionCategory("active");
    return protecteddataRepository.save(data);

    }

    @Transactional
    public ProtectedDataEntity updateProtectedData(ProtectedDataEntity source) {
        ProtectedDataEntity data = protecteddataRepository.findById(source.getId()).orElseThrow(() -> new RuntimeException("Personnel not found"));
        data.setUserId(source.getUserId());
        data.setLastname(source.getLastname());
        data.setFirstname(source.getFirstname());
        data.setMiddlename(source.getMiddlename());
        data.setExtension(source.getExtension());
        data.setAfpsn(source.getAfpsn());
        data.setBos(source.getBos());
        data.setDateEnterMilitaryService( source.getDateEnterMilitaryService());
        data.setBirthdate(source.getBirthdate());
        data.setSex(source.getSex());
        data.setSourceComms(source.getSourceComms());
        data.setClassType(source.getClassType());
        data.setFosRating(source.getFosRating());
        data.setAuthority(source.getAuthority());
        data.setMobileNumber(source.getMobileNumber());
        data.setEmailAddress(source.getEmailAddress());
        data.setCivilStatus(source.getCivilStatus());
        data.setBloodType(source.getBloodType());
        data.setPhysicalProfile(source.getPhysicalProfile());
        data.setEthnicity(source.getEthnicity());
        data.setReligion(source.getReligion());
        data.setSecurityLevel(source.getSecurityLevel());
    return protecteddataRepository.save(data);

    }
    
   
   
    // public Map<String, int[]> getSummaryByRankGenderCategory(List<ProtectedData> personnelList) {
    //     Map<String, int[]> summary = new TreeMap<>(Comparator.reverseOrder());

    //     for (ProtectedData p : personnelList) {
    //         String rank = p.getRankCode();
    //         String afpsn = p.getAfpsn();
    //         long sex = p.getSex().getId();

        
    //         if (afpsn == null || !afpsn.contains("O-")) {
    //             continue; 
    //         }

    //         String[] afpsnParts = afpsn.split("-");

            
    //         if (afpsnParts.length < 2) {
    //             continue; 
    //         }

    //         boolean isRegular = afpsnParts[1].length() < 6;
    //         int genderIndex = (sex == 1) ? 0 : 1;          
    //         int categoryIndex = isRegular ? 0 : 2;        

    //         summary.putIfAbsent(rank, new int[4]);
    //         summary.get(rank)[categoryIndex + genderIndex]++;
    //     }

    //     return summary;
    // }

   
    // public Map<String, int[]> getSummaryExcludingOfficers(List<ProtectedData> personnelList) {
    //     Map<String, int[]> summary = new TreeMap<>(Comparator.reverseOrder());
    
    //     for (ProtectedData p : personnelList) {
    //         String rank = p.getRankCode();
    //         long sex = p.getSex().getId();
    

    //         if (rank != null && rank.startsWith("O-")) {
    //             continue;
    //         }
    
    //         int genderIndex = (sex == 1) ? 0 : 1; 
    //         int categoryIndex = 0;
    
    //         summary.putIfAbsent(rank, new int[4]);
    //         summary.get(rank)[categoryIndex + genderIndex]++;
    //     }
    
    //     return summary;
    // }


    
    // public  Map<FosRating, List<ProtectedData>> getGroupedPersons() {
    //     List<ProtectedData> all = protecteddataRepository.findAllByOrderByFosRatingAscSortedNumberAsc();

    //     return all.stream()
    //             .collect(Collectors.groupingBy(
    //                 ProtectedData::getFosRating,
    //                     LinkedHashMap::new,
    //                     Collectors.toList()
    //             ));
    // }

    
    //  public void updateStatusToResign(Long id) {
    //     Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("resigned");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }


    
    //  public void updateStatusToRetired(Long id) {
    //      Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("retired");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }

    
    //  public void updateStatusToActive(Long id) {
    //     Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("active");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }

    //  public void updateStatusToAwol(Long id) {
    //     Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("awol");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }

    //  public void updateStatusToDueforRetirent(Long id) {
    //     Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("due for retirement");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }

    //   public void updateStatusToChangeFos(Long id) {
    //     Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("change fosrating");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }
     

    //  public void updateStatusToDisease(Long id) {
    //     Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("disease");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }

    //  public void updateStatusToDicharge(Long id) {
    //     Optional<ProtectedData> userOptional = protecteddataRepository.findById(id);
    //     if (userOptional.isPresent()) {
    //         ProtectedData user = userOptional.get();
    //         user.setStatus_definition_category("discharge");
    //         protecteddataRepository.save(user);
    //     } else {
    //         throw new RuntimeException("User not found with ID: " + id);
    //     }
    //  }

    // public List<Object[]> getRetirementRequests() {
    //     return protecteddataRepository.dueForRetirements();
    // }

    // public List<Object[]> getChangeFosRating() {
    //     return changeFosRepository.findAllChangeFosPersonnel();
    // }
     



    
}



