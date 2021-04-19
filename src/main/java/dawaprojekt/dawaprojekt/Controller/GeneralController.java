package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.Service.AuctionService;
import dawaprojekt.dawaprojekt.Service.BidService;
import dawaprojekt.dawaprojekt.Service.Placeholders;
import dawaprojekt.dawaprojekt.Service.UserService;
import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.model.Bid;
import dawaprojekt.dawaprojekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class GeneralController {

    @Autowired
    UserService userService;

    @Autowired
    AuctionService auctionService;

    @Autowired
    Placeholders placeholders;

    @Autowired
    BidService bidService;

    User user;
    int currentPage = 1;

    @GetMapping("/signIn")
    public String signIn(Authentication authentication) {
        login(authentication.getName());
        if (user != null) {
            return "redirect:/auctions/1";
        }
        return "redirect:/login";
    }

    @GetMapping("/admin/{pageCurrent}")
    public String showAdminPage(Model model) {
        model.addAttribute("user", user);

        return "adminPage";
    }

    //TODO: Show a users information when clicking on their name.

    @GetMapping("/auctions/{pageCurrent}")
    public String showUserPage(Model model,
                               @PathVariable(name = "pageCurrent") int pageNum) {

        model.addAttribute("bid", new Bid());
        model.addAttribute("auct", new Auction());
        model.addAttribute("placeholders", placeholders.getPlaceholder() + "....");
        model.addAttribute("auction", new Auction());
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getUsers());
        currentPage = pageNum;
        int pageSize = 3;
        Page<Auction> page = auctionService.findPageinated(currentPage, pageSize);
        List<Auction> listAuction = page.getContent();

        model.addAttribute("pageCurrent", currentPage);
        model.addAttribute("pageTotal", page.getTotalPages());
        model.addAttribute("auctionList", listAuction);
        

        return "auctions";
    }

    private void login(String username) {
        user = userService.getUser(username);
    }
}