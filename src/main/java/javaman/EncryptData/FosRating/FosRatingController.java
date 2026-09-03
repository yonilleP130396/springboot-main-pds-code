package javaman.EncryptData.FosRating;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fosrating")
public class FosRatingController {

    private final FosRatingService fosRatingService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("fosRatings", fosRatingService.getAll());
        return "Fosrating/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("fosRating", new FosRatingEntity());
        return "Fosrating/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute FosRatingEntity fosRating) {
        fosRatingService.save(fosRating);
        return "redirect:/fosrating";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("fosRating",fosRatingService.getById(id).orElseThrow());
        return "Fosrating/form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute FosRatingEntity fosRating) {
        fosRatingService.update(fosRating);
        return "redirect:/fosrating";
    }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable Long id) {
    //     fosRatingService.delete(id);
    //     return "redirect:/fosrating";
    // }
}

