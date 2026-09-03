package javaman.EncryptData.Bos;

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
@RequestMapping("/bos")
public class BosController {

    private final BosService bosService;


    // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("bosList", bosService.getAll());
        return "Bos/list";
    }


    // CREATE FORM
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("bos", new BosEntity());
        return "Bos/form";
    }


    // CREATE
    @PostMapping("/save")
    public String save(@ModelAttribute BosEntity bos) {
        bosService.save(bos);
    return "redirect:/bos";
    }


    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id,Model model) {
        model.addAttribute("bos",bosService.getById(id).orElseThrow());
    return "Bos/form";
    }


    // UPDATE
    @PostMapping("/update")
    public String update(@ModelAttribute BosEntity bos) {
        bosService.update(bos);
    return "redirect:/bos";
    }


    // DELETE
    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     bosService.delete(id);
    //     return "redirect:/bos";
    // }

}
