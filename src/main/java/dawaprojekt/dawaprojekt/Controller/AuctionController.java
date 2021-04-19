package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.Service.EmailService;
import dawaprojekt.dawaprojekt.Service.UserService;
import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.Service.AuctionService;
import dawaprojekt.dawaprojekt.model.Bid;
import dawaprojekt.dawaprojekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/getAuctions")
    public String getAuctions() {
        return "index";
    }

    // Method to add an auction, Gets the logged in user from the authenication class and adds everything where
    // It should be (User gets an auction on their list, and a n auction gets a user associated to it)
    @RequestMapping(value = "/addAuction", method = RequestMethod.POST)
    public String createAuction(Model model, Authentication authentication,
                                @ModelAttribute(name = "auction") Auction auction,
                                @RequestParam(name = "end") String end) {

        User user = userService.getUser(authentication.getName());

        auction.setUser(userService.getUser(authentication.getName()));
        auctionService.saveAuction(auction, end, user);
        return "redirect:/auctions/1";
    }

    // Delete auction based on the ID of the input
    @RequestMapping(value = "/deleteAuction/{id}")
    public String deleteAuction(@PathVariable("id") int id) {
        auctionService.deleteAuction(id);
        return "redirect:/auctions/1";
    }

    // Sends email to winning bidder
    @RequestMapping("/endAuction/{id}")
    public String endAuction(@PathVariable("id") int id) {
        Auction auction = auctionService.getAuction(id);
        String email = auction.getBids().get(auction.getBids().size() - 1).getUser().getEmail();
        Bid bid = auction.getBids().get(0);

        emailService.sendToWinningBidder(email, auction, bid);
        auctionService.deleteAuction(id);

        return "redirect:/auctions/1";
    }

    //
    @RequestMapping(value = "/editAuction/{id}", method = RequestMethod.POST)
    public String editAuction(@ModelAttribute(name = "auct") Auction auction,
                              @PathVariable(name = "id") int id,
                              @RequestParam(name = "editItemCategory") String itemCategory,
                              @RequestParam(name = "editTitle") String title,
                              @RequestParam(name = "editItemCondition") String condition,
                              @RequestParam(name = "editItemDescription") String description) {

        auction = auctionService.getAuction(id);
        auction.setItemName(title);
        auction.setCategory(itemCategory);
        auction.setItemCondition(condition);
        if (!description.isEmpty())
            auction.setDescription(description);
        System.out.println(id + title + itemCategory);
        System.out.println(auction);
        auctionService.saveAuction(auction);

        return "redirect:/auctions/1";
    }
}
