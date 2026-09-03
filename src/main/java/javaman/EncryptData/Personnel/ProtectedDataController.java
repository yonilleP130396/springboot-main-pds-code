package javaman.EncryptData.Personnel;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import java.io.IOException;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Value;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;

// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import javaman.EncryptData.UsersAccount.*;
import javaman.EncryptData.ActivityLogs.*;
import javaman.EncryptData.AllDataCompiled.AllDataCompiledService;
import javaman.EncryptData.AllDataCompiled_V2.AllDataCompiledService_V2;
import javaman.EncryptData.BloodType.BloodTypeService;
import javaman.EncryptData.Bos.BosService;
import javaman.EncryptData.CivilStatus.CivilStatusService;
import javaman.EncryptData.CountAllPersonnel.CountOfAllPersonnelService;
import javaman.EncryptData.FosRating.FosRatingService;
import javaman.EncryptData.Gender.GenderService;
import javaman.EncryptData.PhysicalProfile.PhysicalProfileService;
import javaman.EncryptData.RegisteredOffice.RegisteredOfficeService;
import javaman.EncryptData.SecurityClearance.SecurityClearanceService;


@Controller
@RequestMapping("/protecteddata")
@CrossOrigin
@RequiredArgsConstructor
public class ProtectedDataController<myuserRepository> {
    
    //private final ProtectedDataService protectedDataService;
    private final MyUserRepository myUserRepository;
    private final MyUserDetailService myUserDetailService;
    private final ActivityLogsService activityLogsService;
    private final CountOfAllPersonnelService countOfAllPersonnelService;
    private final AllDataCompiledService allDataCompiledService;
    private final AllDataCompiledService_V2 allDataCompiledService_V2;
    private final ProtectedDataService protectedDataService;
    private final RegisteredOfficeService registeredOfficeService;
    private final GenderService genderService;
    private final CivilStatusService civilStatusService;
    private final BloodTypeService bloodTypeService;
    private final BosService bosService;
    private final FosRatingService fosRatingService;
    private final PhysicalProfileService physicalProfileService;
    private final SecurityClearanceService securityClearanceService;
    
    
    @Value("${app.secret-key}")
    private String appSecretKey;



    //mapping for the sidebar or index.html
    @GetMapping
    public String getIndexPage(Model model) {
        
        model.addAttribute("username", myUserDetailService.getCurrentUserFullName());
        //activityLogsService.saveActivityLogin(fullName,"Successfully Login");
        
        return "Administrator/ProtectedData/index";
    }


    //mapping for mainpage.html iframe

     @GetMapping("/mainpage")
     public String getAllPersonnelData(Model model) {
        activityLogsService.saveActivityLogin(myUserDetailService.getCurrentUserFullName(),"Successfully Login");
        
        model.addAttribute("totalPersonnel", countOfAllPersonnelService.getAll());
        model.addAttribute("protecteddata", allDataCompiledService_V2.getAll());

        
        model.addAttribute("appSecretKey", appSecretKey);

//         List<DashboardAggregate> rankData = dashboardService.getByGraphType("Count by rank");
//         List<DashboardAggregate> genderData = dashboardService.getByGraphType("Gender distribution");

//             // Extract labels and values
//         List<String> rankLabels = rankData.stream()
//                                             .map(DashboardAggregate::getCategoryText)
//                                             .collect(Collectors.toList());

//         List<Long> rankValues = rankData.stream()
//                                             .map(DashboardAggregate::getValue)
//                                             .collect(Collectors.toList());

//         long totalRankValue = rankValues.stream()
//                                         .mapToLong(Long::longValue)
//                                         .sum();
                                        
//        model.addAttribute("totalRankValue", totalRankValue);                                
//         model.addAttribute("rankLabels", rankLabels);
//         model.addAttribute("rankValues", rankValues);
//         model.addAttribute("genderData", genderData);
        
           
       
       

           return "Administrator/ProtectedData/mainpage";
    }


     public void ApiForDropDown(Model model){
         model.addAttribute("offices",registeredOfficeService.getAll());

         model.addAttribute("gender",genderService.getAll());
         model.addAttribute("civilstatus",civilStatusService.getAll());
         model.addAttribute("bloodtype",bloodTypeService.getAll());
         model.addAttribute("bos",bosService.getAll());
         model.addAttribute("fosrating",fosRatingService.getOnlyISFRating());
         model.addAttribute("physicalprofile",physicalProfileService.getAll());
         model.addAttribute("securitylevel",securityClearanceService.getAll());
//         // Get all ranks from the service
//         List<Rank> ranks = rankService.getAllRankAndRankwithoutRating();
//         model.addAttribute("ranks", ranks);
//         model.addAttribute("militarystatus",militaryStatusService.getAllMilitaryCategory());
//model.addAttribute("civilstatus",civilStatusService.getAllCivilStatus());
//        
//         model.addAttribute("serviceprovider",serviceProviderService.getAllServiceProviders());
//         model.addAttribute("region",regionService.getAllRegion());
//         model.addAttribute("bos",branchOfServiceService.getAllBranchOfService());
//         model.addAttribute("fosrating",fosRatingService.getAllFosRating());
//         
//         model.addAttribute("rankcode",rankCodeService.getAllRankCode());
//         
//         model.addAttribute("typesofunitassignment",typesOfUnitAssignmentService.getAllTypesOfUnitAssignment());
//         model.addAttribute("assignmentstatus",assignmentStatusService.getAllAssignmentStatus());
//         model.addAttribute("fielddutystatus",fieldDutyStatusService.getAllFieldDutyStatus());
//         model.addAttribute("promotioncategory",promotionCategoryService.getAllPromotionCategory());
//         model.addAttribute("reenlistmentcategory",reenlistmentCategoryService.getAllReenlistmentCategory());
//         model.addAttribute("coursetype",courseTypeService.getAllCourseType());
//         model.addAttribute("highcarreercourse",highCarreerCourseService.getAllHighCarreerCourse());
//         model.addAttribute("remarks", remarksService.getAllRemarks());
//         model.addAttribute("courselevel", courseLevelService.getAllCourseLevels());
//         model. addAttribute("personnelstatusinmilitary",personnelStatusinServiceRepository.findAll());
//         model.addAttribute("subspecialization", subSpecializationRepository.findAll());
//         model.addAttribute("staffspecialization",staffSpecializationRepository.findAll());
//          model.addAttribute("courseNames", schoolingCourseRepository.findAll());
     }
    

    @GetMapping("/personnelform")
    public String showAddPersonnelForm(Model model) {
         model.addAttribute("personnel", new ProtectedDataEntity());
         ApiForDropDown(model);
       return "Administrator/ProtectedData/add_personnel";
    }


// //#####START OF CREATE, UPDATE, DELETE FUNCTION


//     @PostMapping("/{id}/save_edit")
//     public String saveBook(@PathVariable("id") Long id,@ModelAttribute("personnel") ProtectedData protecteddata,Model model) {
//         protecteddataService.saveProtectedData(protecteddata);

//         ProtectedData serialNumber = protectedDataService.getProtectedDataById(id);
       
//         List<Assignment> assignments = new ArrayList<>();
//         if (serialNumber != null) {
//             assignments = assignmentService.getAssignmentBySerialNumber(serialNumber);
//         }
//         assignments.sort(Comparator.comparing(Assignment::getDateassigned, Comparator.nullsLast(Comparator.reverseOrder())));

//         model.addAttribute("personneldata",protectedDataService.getProtectedDataById(id));
//         model.addAttribute("assignment",assignments);

//         String urlpath = "redirect:/personnelprofile/" + id + "/profile";
//        return urlpath;
//     }

    @PostMapping("/save")
    public String saveaddPersonnel(@ModelAttribute ProtectedDataEntity protecteddata, RedirectAttributes redirectAttributes,  Model model, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("infoMessage","Personnel information successfully saved.");
        protectedDataService.saveProtectedData(protecteddata);
        return "redirect:mainpage"; 
    }


    @PostMapping("/update")
    public String uodatePersonnel(@ModelAttribute ProtectedDataEntity protecteddata, RedirectAttributes redirectAttributes,  Model model, HttpServletRequest request) {
        redirectAttributes.addFlashAttribute("infoMessage","Personnel information successfully updated.");
        protectedDataService.updateProtectedData(protecteddata);
        return "redirect:mainpage"; 
    }


    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("personnel", protectedDataService.getById(id));

        ApiForDropDown(model);
        return "Administrator/ProtectedData/edit_personnel";
    }

    

//     // ✅ Route 2: GET /protecteddata/delete/{id}
//     @GetMapping("/delete/{id}")
//     public String deleteAssignment(@PathVariable Long id, 
//                                 @RequestHeader(value = "Referer", required = false) String referer) {

//         // notificationMilitaryschoolingService.deleteData(id);
//         protecteddataService.deleteData(id);
//         return "redirect:" + (referer != null ? referer : "/defaultRedirectPage");
//     }

//     @GetMapping("/transferdata/{id}")
//     public String TransferPersonnel(@PathVariable Long id, Model model) {

//         model.addAttribute("offices",allOfficeUserService.getAllAccountOffices());
//         model.addAttribute("personneldata",protectedDataService.getProtectedDataById(id));
       
//         return "Administrator/ProtectedData/movedata";
//     }

//     @PostMapping("/updateUserAccount")
//     public String updateUserId(@RequestParam("userId") Long userId, @RequestParam("personnelId") Long personnelId, Model model) {
//         protectedDataService.updateUserId(personnelId, userId);
//         return "redirect:mainpage";
//     }




//      // Handle update to 'resign' - triggered by form/button submit
//     @GetMapping("/{id}/resign")
//     public String resignStatus(@PathVariable Long id, RedirectAttributes redirectAttrs, HttpServletRequest request) {
//          String referer = request.getHeader("Referer");
//         protecteddataService.updateStatusToResign(id);
//         redirectAttrs.addFlashAttribute("successupdateresigned", "Status updated to resigned.");
//         return "redirect:" + referer;  
//     }

    
//     @GetMapping("/{id}/retired")
//     public String retiredStatus(@PathVariable Long id, RedirectAttributes redirectAttrs, HttpServletRequest request) {
//          String referer = request.getHeader("Referer");
//         protecteddataService.updateStatusToRetired(id);
//         redirectAttrs.addFlashAttribute("successupdateretired", "Status updated to retired.");
//          return "redirect:" + referer; 

//     }

//     @GetMapping("/{id}/active")
//     public String activeStatus(@PathVariable Long id, RedirectAttributes redirectAttrs, HttpServletRequest request) {
//          String referer = request.getHeader("Referer");
//         protecteddataService.updateStatusToActive(id);
//         redirectAttrs.addFlashAttribute("successupdateactive", "Status updated to retired.");
//          return "redirect:" + referer; 

//     }
//     @GetMapping("/{id}/awol")
//     public String awolStatus(@PathVariable Long id, RedirectAttributes redirectAttrs, HttpServletRequest request) {
//          String referer = request.getHeader("Referer");
//         protecteddataService.updateStatusToAwol(id);
//         redirectAttrs.addFlashAttribute("successupdateactive", "Status updated to awol.");
//          return "redirect:" + referer; 

//     }
//     @GetMapping("/{id}/disease")
//     public String diseaseStatus(@PathVariable Long id, RedirectAttributes redirectAttrs, HttpServletRequest request) {
//          String referer = request.getHeader("Referer");
//         protecteddataService.updateStatusToDisease(id);
//         redirectAttrs.addFlashAttribute("successupdateactive", "Status updated to Disease.");
//          return "redirect:" + referer; 

//     }
//     @GetMapping("/{id}/discharge")
//     public String diseasedischarge(@PathVariable Long id, RedirectAttributes redirectAttrs, HttpServletRequest request) {
//          String referer = request.getHeader("Referer");
//         protecteddataService.updateStatusToDicharge(id);
//         redirectAttrs.addFlashAttribute("successupdateactive", "Status updated to Discharge.");
//          return "redirect:" + referer; 

//     }

//     // @GetMapping("/attrition")
//     // public String getAtrriation(Model model) {
//     //     model.addAttribute("totalresigned", protecteddataService.countByStatusDefinitionResigned());
//     //     model.addAttribute("totalawol", protecteddataService.countByStatusDefinitionAwol());
//     //     model.addAttribute("totalretired", protecteddataService.countByStatusDefinitionRetiree());
//     //     model.addAttribute("dueforretiremnt", protecteddataService.countByStatusDefinitionDueForRetirement());
//     //     model.addAttribute("totalchangerate", protecteddataService.countByStatusChangeFosRating());
//     //     model.addAttribute("totaldisease", protecteddataService.countByStatusDefinitionDisease());
//     //     model.addAttribute("totaldischarge", protecteddataService.countByStatusDefinitionDischarge());
        
//     //     return "Administrator/ProtectedData/attrition";
//     // }

//     @GetMapping("/attrition")
// public String getAtrriation(
//         @RequestParam(required = false) String afpsn,
//         Model model) {

//     // Search Personnel
//     if (afpsn != null && !afpsn.trim().isEmpty()) {
//         model.addAttribute("personnels",
//                 protecteddataService.findAllAfpsnContaining(afpsn));
//     }

//     model.addAttribute("afpsn", afpsn);

//     // Summary Counts
//     model.addAttribute("totalresigned", protecteddataService.countByStatusDefinitionResigned());
//     model.addAttribute("totalawol", protecteddataService.countByStatusDefinitionAwol());
//     model.addAttribute("totalretired", protecteddataService.countByStatusDefinitionRetiree());
//     model.addAttribute("dueforretiremnt", protecteddataService.countByStatusDefinitionDueForRetirement());
//     model.addAttribute("totalchangerate", protecteddataService.countByStatusChangeFosRating());
//     model.addAttribute("totaldisease", protecteddataService.countByStatusDefinitionDisease());
//     model.addAttribute("totaldischarge", protecteddataService.countByStatusDefinitionDischarge());

//     return "Administrator/ProtectedData/attrition";
// }

//     @GetMapping("/resigned")
//     public String getResigned(Model model) {
//         List<ProtectedData> resign = protecteddataService.findResigned();   
//         model.addAttribute("resign", resign);
//         return "Administrator/ProtectedData/resigned";
//     }

//     @GetMapping("/awol")
//     public String getAwol(Model model) {
//         List<ProtectedData> awol = protecteddataService.findAwol();   
//         model.addAttribute("awol", awol);
//         return "Administrator/ProtectedData/awol";
//     }

//     @GetMapping("/retired")
//     public String getRetired(Model model) {
//         List<ProtectedData> retired = protecteddataService.findRetired();   
//         model.addAttribute("retired", retired);
//         return "Administrator/ProtectedData/retired";
//     }

//     @GetMapping("/relieved")
//     public String getAllPersonnelDataRelived(Model model) throws SQLException, IOException, ServletException {
       
//         List<ProtectedData> relieved = protecteddataService.findRelieved();
//         relieved.sort(Comparator.comparing(ProtectedData::getSortednumber));
//         model.addAttribute("relieved", relieved);
        
//         return "Administrator/RelievedPersonnel/index";
//     }

//     @GetMapping("/newlyaboard")
//     public String getAllPersonnelDataNewLyAboard(Model model) throws SQLException, IOException, ServletException {
        
//         List<ProtectedData> data = protecteddataService.findNewlyAboard();
//         data.sort(Comparator.comparing(ProtectedData::getSortednumber));
//         model.addAttribute("protecteddata", data);
//         return "Administrator/NewlyAboard/newlyaboard";
//     }

//     @GetMapping("/carreerprogression")
//     public String getCarreerProgression(Model model) throws SQLException, IOException, ServletException {
        
//         model.addAttribute("protecteddata", midtermReenlistmentService.getMidternReenlistment());
//         return "Administrator/CareerProgression/careerprogression";
//     }

//     @GetMapping("/midtermreenlistment")
//     public String getMidtermreenlistment(Model model) throws SQLException, IOException, ServletException {
        
//         model.addAttribute("protecteddata", midtermReenlistmentService.getMidternReenlistment());
//         //model.addAttribute("protecteddata", midtermReenlistmentRepository.findAllPersonnelReenlistment());
//         return "Administrator/CareerProgression/midtermreenlistment";
//     }

//     @GetMapping("/promotion")
//     public String getPromotion(Model model) throws SQLException, IOException, ServletException {
//         model.addAttribute("protecteddata", promotionComputationRepository.findAll());
//          return "Administrator/CareerProgression/promotion";
//     }

//     @GetMapping("/schooling")
//     public String getforSchooling(Model model) throws SQLException, IOException, ServletException {
//         model.addAttribute("forsbc",forShoolingRepository.findByRemarks("FOR SBC"));
//         model.addAttribute("fornepbic",forShoolingRepository.findByRemarks("FOR NEPBIC"));
//         model.addAttribute("forascskill",forShoolingRepository.findByRemarks("FOR ASC SKILLS"));
//         model.addAttribute("ascleadership",forShoolingRepository.findByRemarks("FOR ASC LEADERSHIP"));
//         model.addAttribute("forafpsmc",forShoolingRepository.findByRemarks("FOR AFPSMC"));
//         model.addAttribute("forsmc",forShoolingRepository.findByRemarks(" FOR SMC"));
//         model.addAttribute("fornepismc",forShoolingRepository.findByRemarks("FOR NEPISMC SKILLS"));
//         model.addAttribute("doneafpsmc",forShoolingRepository.findByRemarks("DONE AFPSMC"));
//         model.addAttribute("doneepaac",forShoolingRepository.findByRemarks("DONE EPAAC"));
        
//         return "Administrator/CareerProgression/schooling";
//     }

//     @GetMapping("/dueforretirement")
//     public String getdueforretirement(Model model) throws SQLException, IOException, ServletException {
//         model.addAttribute("dueforretirement", protecteddataService.getRetirementRequests());
//         return "Administrator/ProtectedData/dueforretirement";
//     }

//     @GetMapping("/changefos")
//     public String getchangefos(Model model) throws SQLException, IOException, ServletException {
//         model.addAttribute("changefos", protecteddataService.getChangeFosRating());
//         return "Administrator/ProtectedData/changefos";
//     }

//     @GetMapping("/disease")
//     public String getdisease(Model model) throws SQLException, IOException, ServletException {
//         model.addAttribute("disease", protecteddataService.findDiseased());
//         return "Administrator/ProtectedData/disease";
//     }

//     @GetMapping("/discharge")
//     public String getdischarge(Model model) throws SQLException, IOException, ServletException {
//         model.addAttribute("discharge", protecteddataService.findDischarged());
//         return "Administrator/ProtectedData/discharge";
//     }

//     public String getCurrentUsername() {
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         if (authentication != null && authentication.isAuthenticated()) {
//             return authentication.getName(); 
//         }
//         return null;
//     }
}
