package dawaprojekt.dawaprojekt.Service;

import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.Repository.AuctionRepository;
import dawaprojekt.dawaprojekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private DateToDateTime dateToDateTime;

    @Autowired
    EmailService emailService;

    public Page<Auction> findPageinated(int pageNr, int pageSize) {
        Pageable pageable = PageRequest.of(pageNr - 1, pageSize, Sort.by(Sort.Direction.DESC, "auctionID"));
        return auctionRepository.findAll(pageable);
    }

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuction(int id) {
        return auctionRepository.findById(id).orElse(null);
    }

    public Auction saveAuction(Auction auction, String end, User user) {
        auction.setEndDate(dateToDateTime.auctionTime(end));

        sendEmail(auction);
        return auctionRepository.save(auction);
    }

    public Auction saveAuction(Auction auction) {
        sendEmail(auction);
        return auctionRepository.save(auction);
    }

    public void deleteAuction(Integer auctionID) {
        auctionRepository.deleteById(auctionID);
    }

    private void sendEmail(Auction auction) {
        emailService.sendAuctionConfirmation("h19dummywonderacc@gmail.com", auction);
    }

}