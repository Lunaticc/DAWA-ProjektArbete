package dawaprojekt.dawaprojekt.Repository;

import dawaprojekt.dawaprojekt.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {
    List<Auction> findAll();
}

