package javaman.EncryptData.Gender;

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
@RequestMapping("/gender")
public class GenderController {
    public final GenderService genderService;



 // READ ALL
    @GetMapping
    public String getAll(Model model) {

        model.addAttribute("genders", genderService.getAll());

        return "Gender/list";
    }


    // CREATE
    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("gender", new GenderEntity());

        return "Gender/gender-form";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute GenderEntity gender) {

        genderService.save(gender);

        return "redirect:/Gender/list";
    }


    // UPDATE
    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "gender",
                genderService.getById(id)
        );

        return "Gender/gender-form";
    }


    @PostMapping("/update/{id}")
    public String update(@ModelAttribute GenderEntity gender) {

        genderService.update(gender);

        return "redirect:/protecteddata/genders";
    }


    // // DELETE
    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {

    //     genderService.delete(id);

    //     return "redirect:/protecteddata/genders";
    // }
}
