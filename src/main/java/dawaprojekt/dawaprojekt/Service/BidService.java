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

    // Add Bid
    public Bid addBid(Bid bid){
        return bidRepository.save(bid);
    }

    // Remove bid?!?!?!?!

    public void removeBid(Bid bid){
        bidRepository.delete(bid);
    }
    // Get all bids

    public List<Bid> getAll(){
        return bidRepository.findAll();
    }

}