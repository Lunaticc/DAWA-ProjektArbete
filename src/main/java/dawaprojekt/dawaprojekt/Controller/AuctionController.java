package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.Service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

//    @GetMapping("/getAuctions")
//    public String getAuctions(){
//        return "index";
//    }


}
