package dawaprojekt.dawaprojekt.model;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auctionID;

    @Column(nullable = true, length = 4000)
    private String description;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private double reservedPrice;
    @Column(nullable = false)
    private LocalDateTime endDate;
    @Column(nullable = false)
    private String itemCondition;
    @Column(nullable = false)
    private String urlImage;
    @Column(nullable = false)
    private String category;
    @Column(nullable = true)
    private double highestBid;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(
            mappedBy = "auction",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("amount DESC")
    private List<Bid> bids = new ArrayList<>();

    public void addBid(Bid bid) {
        this.bids.add(bid);
        bid.setAuction(this);
    }

    public void removeBid(Bid bid) {
        this.bids.remove(bid);
        bid.setAuction(null);
    }

    public Auction() {
    }

    public Auction(String description, String itemName, double reservedPrice, LocalDateTime endDate, String itemCondition, String urlImage, String category) {
        this.description = description;
        this.itemName = itemName;
        this.reservedPrice = reservedPrice;
        this.endDate = endDate;
        this.itemCondition = itemCondition;
        this.urlImage = urlImage;
        this.category = category;
    }

    public int getAuctionID() {
        if (auctionID != null) {
            return auctionID;
        }
        return -1;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getReservedPrice() {
        return reservedPrice;
    }

    public void setReservedPrice(double reservedPrice) {
        this.reservedPrice = reservedPrice;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(String condition) {
        this.itemCondition = condition;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setAuctionID(Integer auctionID) {
        this.auctionID = auctionID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public List<Bid> getBids() {
        return bids;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionID=" + auctionID +
                ", description='" + description + '\'' +
                ", itemName='" + itemName + '\'' +
                ", reservedPrice=" + reservedPrice +
                ", endDate=" + endDate +
                ", itemCondition='" + itemCondition + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
