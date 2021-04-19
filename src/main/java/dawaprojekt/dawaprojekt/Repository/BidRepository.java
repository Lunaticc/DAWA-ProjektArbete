package dawaprojekt.dawaprojekt.Repository;

import dawaprojekt.dawaprojekt.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {
    List<Bid> findAll();

    @Query(nativeQuery = true, value = "Select * from bid where auction_auctionid = ? ORDER BY amount Desc LIMIT 3")
    List<Bid> getTopBids(Integer id);
}

