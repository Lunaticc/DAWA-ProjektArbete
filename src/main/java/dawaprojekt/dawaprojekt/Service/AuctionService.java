package dawaprojekt.dawaprojekt.Service;

import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.Repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> getAllAuctions(){
        return auctionRepository.findAll();
    }

    public Auction getAuction(int id){
        return auctionRepository.findById(id).orElse(null);
    }

    public Auction saveAuction(Auction auction){
        return auctionRepository.save(auction);
    }

    public void deleteAuction(Integer auctionID){
        auctionRepository.deleteById(auctionID);
    }

}