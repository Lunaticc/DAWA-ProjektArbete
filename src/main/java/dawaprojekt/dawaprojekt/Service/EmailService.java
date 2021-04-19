package dawaprojekt.dawaprojekt.Service;

import dawaprojekt.dawaprojekt.model.Auction;
import dawaprojekt.dawaprojekt.model.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendAuctionConfirmation(String to, Auction auction) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("h19dummywonderacc@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("Your item: " + auction.getItemName() + " has been put up on auction!");
        simpleMailMessage.setText("Your reserved price: " + auction.getReservedPrice() + "kr" +
                "\nItem condition: " + auction.getItemCondition() +
                "\nItem description: " + auction.getDescription() +
                "\nItem category: " + auction.getCategory() +
                "\nPlease check that your URL is working: " + auction.getUrlImage() +
                "\nEnd date: " + auction.getEndDate());
        javaMailSender.send(simpleMailMessage);
    }

    public void sendToBidder(String to, Auction auction, Bid bid) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("h19dummywonderacc@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("You have bid on item: " + auction.getItemName());
        simpleMailMessage.setText("The reserved price: " + auction.getReservedPrice() + "kr" +
                "\nThe item condition: " + auction.getItemCondition() +
                "\nThe item description: " + auction.getDescription() +
                "\nThe item category: " + auction.getCategory() +
                "\nThe item URL: " + auction.getUrlImage() +
                "\nEnd date: " + auction.getEndDate() +
                "\nYour bid: " + bid.getAmount() + "kr");
        javaMailSender.send(simpleMailMessage);
    }

    public void sendToWinningBidder(String to, Auction auction, Bid bid) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("h19dummywonderacc@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("Your have won the auction of item: " + auction.getItemName() + "!");
        simpleMailMessage.setText("Final bid: " + bid.getAmount() + "kr" +
                "\nReserved price: " + auction.getReservedPrice() +
                "\nItem condition: " + auction.getItemCondition() +
                "\nItem description: " + auction.getDescription() +
                "\nItem category: " + auction.getCategory() +
                "\nItem URL: " + auction.getUrlImage() +
                "\nEnd date: " + auction.getEndDate());
        javaMailSender.send(simpleMailMessage);
    }
}