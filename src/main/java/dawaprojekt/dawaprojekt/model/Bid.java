package dawaprojekt.dawaprojekt.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bidID;

    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Auction auction;

    public Bid() {
    }

    public Bid(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public int getBidID() {
        return bidID != null ? bidID : -1;
    }

    public void setBidID(int bidID) {
        this.bidID = bidID;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBidID(Integer bidID) {
        this.bidID = bidID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidID=" + bidID +
                ", amount=" + amount +
                ", date=" + date +
                ", user=" + user +
                ", auction=" + auction +
                '}';
    }
}
