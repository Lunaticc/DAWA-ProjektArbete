package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.Service.AuctionService;
import dawaprojekt.dawaprojekt.Service.BidService;
import dawaprojekt.dawaprojekt.Service.UserService;
import dawaprojekt.dawaprojekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;


@Controller
public class GeneralController {

    @Autowired
    UserService userService;

    User user;

    @GetMapping("/signIn")
    public String signIn(Authentication authentication){
        login(authentication.getName());
        if(user != null){
            if (user.getRole().equalsIgnoreCase("role_admin")){
                return "redirect:/admin";
            } else {
                return "redirect:/user";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model){
        model.addAttribute("user", user);
        return "adminPage";
    }

    @GetMapping("/user")
    public String showUserPage(Model model){
        model.addAttribute("user", user);
        return "userPage";
    }

    private void login(String username){
        user = userService.getUser(username);
    }

    @GetMapping("/bidder")
    public String showBidderPage(Model model){


        return "bidderpage";
    }

}