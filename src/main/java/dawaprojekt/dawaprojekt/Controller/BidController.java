package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.Service.AuctionService;
import dawaprojekt.dawaprojekt.Service.UserService;
import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.model.Bid;
import dawaprojekt.dawaprojekt.Service.BidService;
import dawaprojekt.dawaprojekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Controller
public class BidController {
    @Autowired
    private BidService bidService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuctionService auctionService;

    @RequestMapping(value = "/addbid/{auctionID}", method = RequestMethod.POST)
    public String addBid(Model model, Authentication authentication,
                         @ModelAttribute(name = "bid") Bid bid,
                         @PathVariable("auctionID") int id) {

        Auction auction = auctionService.getAuction(id);
        User user = userService.getUser(authentication.getName());
        String redirect = "redirect:/auctions/1";

        if (bid.getAmount() <= auction.getReservedPrice() || bid.getAmount() <= auction.getHighestBid()) {
            return redirect;
        }
        auction.setHighestBid(bid.getAmount());
        bid.setUser(user);
        bid.setAuction(auction);
        bid.setDate(new Date());
        bidService.addBid(bid);
        return "redirect:/auctions/1";
    }

    private Bid getHighest(Auction auction) {

        return null;
    }


}