package javaman.EncryptData.PhysicalProfile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/physicalprofile")
public class PhysicalProfileController {

    private final PhysicalProfileService physicalProfileService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("physicalProfiles",physicalProfileService.getAll());
        return "PhysicalProfile/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("physicalProfile",new PhysicalProfileEntity());
        return "PhysicalProfile/form";
    }

    @PostMapping("/save")
    public String save( @ModelAttribute PhysicalProfileEntity physicalProfile) {
        physicalProfileService.save(physicalProfile);
        return "redirect:/physicalprofile";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model) {
        model.addAttribute("physicalProfile",physicalProfileService.getById(id).orElseThrow());
        return "PhysicalProfile/form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute PhysicalProfileEntity physicalProfile) {
        physicalProfileService.update(physicalProfile);
        return "redirect:/physicalprofile";
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {

    //     physicalProfileService.delete(id);

    //     return "redirect:/physicalprofile";
    // }
}
