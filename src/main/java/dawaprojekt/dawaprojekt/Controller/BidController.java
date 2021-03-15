package dawaprojekt.dawaprojekt.Controller;

import dawaprojekt.dawaprojekt.model.Bid;
import dawaprojekt.dawaprojekt.Service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BidController {
    @Autowired
    private BidService bidService;

    //Add Bid
    public Bid addBid(Bid bid){
        return bidService.addBid(bid);
    }

    //Remove Bid, Do you even do that?
    public void removeBid(Bid bid){
        bidService.removeBid(bid);
    }
    
    

}