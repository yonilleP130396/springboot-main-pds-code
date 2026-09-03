package javaman.EncryptData.PersonnelProfile;



import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javaman.EncryptData.AllDataCompiled.AllDataCompiledEntity;
import javaman.EncryptData.AllDataCompiled.AllDataCompiledService;
import javaman.EncryptData.PromotionReenlistment.PromotionReenlistmentEntity;
import javaman.EncryptData.PromotionReenlistment.PromotionReenlistmentService;



@Controller
@RequestMapping("/personnelprofile")
@RequiredArgsConstructor
public class PersonnelProfileController {
    private final AllDataCompiledService allDataCompiledService;
    private final PromotionReenlistmentService promotionReenlistmentService;

    
    



    @GetMapping
    public String getAssignment(){

        return "PersonnelProfile/index1";
    }

    
     @GetMapping("{id}/profile")
     public String getAssignmentIndex(@PathVariable("id")Long id, Model model){
        
        AllDataCompiledEntity personnel = allDataCompiledService.getById(id).orElseThrow(() -> new RuntimeException("Personnel not found"));
        List<PromotionReenlistmentEntity> proreen = promotionReenlistmentService.getByPersonnelId(id);
        model.addAttribute("personnel", personnel);
        model.addAttribute("proreen", proreen);



       //  ProtectedData serialNumber = protectedDataService.getProtectedDataById(id); 

    //     List<Assignment> assignments = new ArrayList<>();
    //     List<CollateralAssignment> collateralassignments = new ArrayList<>();
    //     List<Promotion> promotions = new ArrayList<>();
    //     List<EtadEteReenlistment> reenlistments = new ArrayList<>();
    //     List<MilitarySchooling> militaryschoolings = new ArrayList<>();
    //     List<CivilianSchooling> civilianschoolings = new ArrayList<>();
        
    //     if (serialNumber != null) {
    //         assignments = assignmentService.getAssignmentBySerialNumber(serialNumber);
    //         collateralassignments = collateralAssignmentService.getCollateralAssignmentBySerialNumber(serialNumber);
    //         promotions = promotionService.getPromotionBySerialNumber(serialNumber);
    //         reenlistments = etadEteReenlistmentService.getEtadEteReenlistmentBySerialNumber(serialNumber);
    //         militaryschoolings = militarySchoolingService.getMilitarySchoolingBySerialNumber(serialNumber);
    //         civilianschoolings = civilianSchoolingService.getCivilianSchoolingBySerialNumber(serialNumber);
    //     }
    //     assignments.sort(Comparator.comparing(Assignment::getDateassumebillet, Comparator.nullsLast(Comparator.reverseOrder())));
    //     collateralassignments.sort(Comparator.comparing(CollateralAssignment::getDateassigned, Comparator.nullsLast(Comparator.reverseOrder())));
    //     promotions.sort(Comparator.comparing(Promotion::getDatepromoted, Comparator.nullsLast(Comparator.reverseOrder())));
    //     reenlistments.sort(Comparator.comparing(EtadEteReenlistment::getDate_etadsotreenlisment, Comparator.nullsLast(Comparator.reverseOrder())));
    //     militaryschoolings.sort(Comparator.comparing(MilitarySchooling::getStart, Comparator.nullsLast(Comparator.reverseOrder())));
    //     civilianschoolings.sort(Comparator.comparing(CivilianSchooling::getStartschoolyear, Comparator.nullsLast(Comparator.reverseOrder())));
        
       
        
    //     model.addAttribute("assignment",assignments);
    //     model.addAttribute("collateralassignment",collateralassignments);
    //     model.addAttribute("promotion",promotions);
    //     model.addAttribute("reenlistment",reenlistments);
    //     model.addAttribute("militaryschooling", militaryschoolings);
    //     model.addAttribute("civilianschooling", civilianschoolings);


    //     ProtectedData personnel = protectedDataService.getProtectedDataById(id);

    //     model.addAttribute("barangayName", psgcApiService.getBarangayName(personnel.getBarangay()));
    //     model.addAttribute("municipalityName", psgcApiService.getMunicipalityName(personnel.getMunicipality()));
    //     model.addAttribute("provinceName", psgcApiService.getProvinceName(personnel.getProvince()));   
        
    //     Optional<ProfilePicture> profilePicture = repo.findByPersonnelID(id);

            
    //         model.addAttribute("profilePicture", profilePicture.orElse(null));



         return "Administrator/PersonnelProfile/index";
     }
}
