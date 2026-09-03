package javaman.EncryptData.CivilStatus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/civil-status")
public class CivilStatusController {

    private final CivilStatusService civilStatusService;


    // =====================================================
    // READ ALL
    // =====================================================

    @GetMapping
    public String getAll(Model model) {

        model.addAttribute(
                "civilStatuses",
                civilStatusService.getAll()
        );

        return "CivilSatatus/civil-status";
    }


    // =====================================================
    // CREATE PAGE
    // =====================================================

    @GetMapping("/create")
    public String createForm(Model model) {

        model.addAttribute("civilStatus",new CivilStatusEntity());

        return "CivilSatatus/civil-status-form";
    }


    // =====================================================
    // CREATE
    // =====================================================

    @PostMapping("/save")
    public String save(
            @ModelAttribute("civilStatus")
            CivilStatusEntity civilStatus) {

        civilStatusService.save(civilStatus);

        return "redirect:/civil-status";
    }


    // =====================================================
    // EDIT PAGE
    // =====================================================

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("civilStatus",civilStatusService.getById(id));

        return "CivilSatatus/civil-status-form";
    }


    // =====================================================
    // UPDATE
    // =====================================================

    @PostMapping("/update")
    public String update(
            @ModelAttribute("civilStatus")
            CivilStatusEntity civilStatus) {

        civilStatusService.update(civilStatus);

        return "redirect:/civil-status";
    }
}
