package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.Service.Placeholders;
import dawaprojekt.dawaprojekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SecurityController {
    
    @Autowired
    private Placeholders placeholders;

    @GetMapping("/")
    public String showIndex() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin(Model model, @ModelAttribute(name = "user") User user) {
        model.addAttribute("imagePlaceholder", placeholders.getImagePlaceholder());
        return "login";
    }
}
