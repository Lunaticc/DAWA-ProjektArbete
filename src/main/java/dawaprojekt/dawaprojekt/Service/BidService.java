package dawaprojekt.dawaprojekt.Service;

import dawaprojekt.dawaprojekt.model.Bid;
import dawaprojekt.dawaprojekt.Repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    EmailService emailService;

    // Add Bid
    public Bid addBid(Bid bid) {
        emailService.sendToBidder(bid.getUser().getEmail(), bid.getAuction(), bid);
        return bidRepository.save(bid);
    }

    // Get all bids
    public List<Bid> getAll() {
        return bidRepository.findAll();
    }

    public List<Bid> getTopBids() {
        return bidRepository.getTopBids(7);
    }

}