package dawaprojekt.dawaprojekt.Service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateToDateTime {

    private DateTimeFormatter formedTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public LocalDateTime currentTime() {
        LocalDateTime dateTime = LocalDateTime.parse(LocalDateTime.now().toString(), formedTime);
        return dateTime;
    }

    public LocalDateTime auctionTime(String ends) {
        String auctionEnding = ends + " 00:00";
        LocalDateTime dateTime = LocalDateTime.parse(auctionEnding, formedTime);
        return dateTime;
    }

}
