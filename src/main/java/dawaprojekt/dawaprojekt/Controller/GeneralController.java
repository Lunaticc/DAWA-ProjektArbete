package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.Service.AuctionService;
import dawaprojekt.dawaprojekt.Service.BidService;
import dawaprojekt.dawaprojekt.Service.UserService;
import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;


@Controller
public class GeneralController {

    @Autowired
    UserService userService;

    @Autowired
    AuctionService auctionService;


    User user;
    int currentPage = 1;

    @GetMapping("/signIn")
    public String signIn(Authentication authentication){
        login(authentication.getName());
        if(user != null){
            if (user.getRole().equalsIgnoreCase("role_admin")){
                return "redirect:/admin/1";
            } else {
                return "redirect:/user/1";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/admin/{pageCurrent}")
    public String showAdminPage(Model model){
        model.addAttribute("user", user);

        return "adminPage";
    }

    @GetMapping("/user/{pageCurrent}")
    public String showUserPage(Model model,
                               @PathVariable(name = "pageCurrent") int pageNum,
                               @ModelAttribute(name = "auction")Auction auction){
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getUsers());

        currentPage = pageNum;
        int pageSize = 3;
        Page<Auction> page = auctionService.findPageinated(currentPage, pageSize);
        List<Auction> listAuction = page.getContent();

        model.addAttribute("pageCurrent", currentPage);
        model.addAttribute("pageTotal", page.getTotalPages());
        model.addAttribute("auctionList", listAuction);

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