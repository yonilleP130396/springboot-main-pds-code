package javaman.EncryptData.RegisteredOffice;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/registered-office")
public class RegisteredOfficeController {

    private final RegisteredOfficeService registeredOfficeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("offices", registeredOfficeService.getAll());
        return "Administrator/RegisteredOffice/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("office", new RegisteredOfficeEntity());
        return "Administrator/RegisteredOffice/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute RegisteredOfficeEntity office) {
        registeredOfficeService.save(office);
        return "redirect:/registered-office";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("office", registeredOfficeService.getById(id));
        return "Administrator/RegisteredOffice/form";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute RegisteredOfficeEntity office) {

        office.setId(id);
        registeredOfficeService.save(office);

        return "redirect:/registered-office";
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     registeredOfficeService.delete(id);
    //     return "redirect:/RegisteredOffice";
    // }
}
