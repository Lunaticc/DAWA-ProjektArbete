package dawaprojekt.dawaprojekt.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auctionID;

    @Column
    private String description;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private double reservedPrice;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private String itemCondition;
    @Column(nullable = false)
    private String urlImage;
    @Column(nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(
            mappedBy = "auction",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Bid> bids = new ArrayList<>();

    public void addBid(Bid bid){
        this.bids.add(bid);
        bid.setAuction(this);
    }

    public void removeBid(Bid bid){
        this.bids.remove(bid);
        bid.setAuction(null);
    }

    public Auction() {
    }

    public Auction(String description, String itemName, double reservedPrice, Date endDate, String itemCondition, String urlImage) {
        this.description = description;
        this.itemName = itemName;
        this.reservedPrice = reservedPrice;
        this.endDate = endDate;
        this.itemCondition = itemCondition;
        this.urlImage = urlImage;
    }

    public int getAuctionID() {
        return auctionID;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
