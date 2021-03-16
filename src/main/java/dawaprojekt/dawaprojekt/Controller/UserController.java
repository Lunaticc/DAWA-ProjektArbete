package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.model.User;
import dawaprojekt.dawaprojekt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/admin/")
//    public String showIndexForAdmin(Model model){
//        model.addAttribute("Suck", "ITITITITITITITITITITITITI");
//        return "adminPage";
//    }
    
    

}