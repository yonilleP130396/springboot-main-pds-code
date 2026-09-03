package javaman.EncryptData.BloodType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bloodtype")
public class BloodTypeController {

    private final BloodTypeService bloodTypeService;

  // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("bloodTypes", bloodTypeService.getAll());
        return "BloodType/list";
    }

    // CREATE FORM
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bloodType", new BloodTypeEntity());
        return "BloodType/form";
    }

    // SAVE
    @PostMapping("/save")
    public String save(@ModelAttribute BloodTypeEntity bloodType) {
        bloodTypeService.save(bloodType);
        return "redirect:/bloodtype";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "bloodType",
                bloodTypeService.getById(id).orElseThrow()
        );

        return "BloodType/form";
    }

    // UPDATE
    @PostMapping("/update")
    public String update(@ModelAttribute BloodTypeEntity bloodType) {
        bloodTypeService.update(bloodType);
        return "redirect:/bloodtype";
    }

    // // DELETE
    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     bloodTypeService.delete(id);
    //     return "redirect:/bloodtype";
    // }
}
