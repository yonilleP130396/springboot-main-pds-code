package javaman.EncryptData.SecurityClearance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/security-clearance")
public class SecurityClearanceController {

    private final SecurityClearanceService securityClearanceService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("securityClearances",securityClearanceService.getAll());
    return "SecurityClearance/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("securityClearance",new SecurityClearanceEntity());
    return "SecurityClearance/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SecurityClearanceEntity securityClearance) {
        securityClearanceService.save(securityClearance);
    return "redirect:/security-clearance";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,Model model) {
        model.addAttribute("securityClearance", securityClearanceService.getById(id).orElseThrow());
    return "SecurityClearance/form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SecurityClearanceEntity securityClearance) {
        securityClearanceService.update(securityClearance);
    return "redirect:/security-clearance";
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {

    //     securityClearanceService.delete(id);

    //     return "redirect:/security-clearance";
    // }
}