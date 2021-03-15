package dawaprojekt.dawaprojekt.Repository;

import dawaprojekt.dawaprojekt.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {
    List<Bid> findAll();
}

