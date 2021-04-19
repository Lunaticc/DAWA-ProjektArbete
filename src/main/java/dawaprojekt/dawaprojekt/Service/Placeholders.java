package dawaprojekt.dawaprojekt.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Placeholders {

    /// Placeholders for the glory of satan himself..
    private String[] placeholders = {"A wonderful item for your son/daughter to play with",
            "An amazing old artifact made from the bones of elephants", "A cum sock",
            "Boneless chicken",
            "A wheel less hot wheel race car, With the track still functional",
            "Some whale blubber, (Dont ask where it came from)",
            "A monkey hand, (With some wishes left)", "Last nights doughnut-hole",
            "A Homer simpsons statue, where he eats(duuh)",
            "Robins Oskuld(Fråga mig inte hur)",
            "Some Dream catchers,(I know the sucked my dreams away from me)",
            "A cursed Doll", "A used noose", "A still smoking gun(help)",
            "An ancient weapon used to hit a puck", "They say that if you hold this item to your ear, you will be able to hear" +
            " the soviet anthem"};

    private String[] imagePlaceholders = {"https://www.drusillas.co.uk/images/explore-more-card/meerkat1-profile-400x400-536.jpg",
                "https://cdn.vox-cdn.com/thumbor/1mxkqqttp-h6NTQ9fF6wbcXMcdg=/12x0:4907x3263/1400x1050/filters:focal(12x0:4907x3263):format(jpeg)/cdn.vox-cdn.com/uploads/chorus_image/image/49388585/16071828377_85109fdee4_o.0.0.jpg",
                "https://pawsnprairie.com/wp-content/uploads/2018/11/Rabbit.jpg",
                "https://lh3.googleusercontent.com/proxy/a1K7_vw-lck90FYkNz3u4fKi0UZe9YkWvjA5asJnWzqe6z3Vi4-V_e3vXjWalWdZ_IO_Z-BIknXLKpv5IG4zt8c5QSNx9bC8xH97_d7gqV0Juvatbz3wz9fGcIEqeqWj",
                "https://i.pinimg.com/originals/1a/e9/e1/1ae9e1e4502a877a606bd8c10c513dc8.jpg",
                "https://64.media.tumblr.com/78226bd1c681d5d6cf2fdcde3a71b281/tumblr_mu9vhoca2X1sq35mxo1_500.jpg",
                "https://lh3.googleusercontent.com/proxy/Oxvn8jtVyypnKdMHiYO4N1kEzvNFbnoR1dm-bISGG3lIrJS0W9rILssKzZwV2ukLGGP0GkXdFBI7XlXs0lEREjt1WApAcUYtU6YGcrNsgWZOkteBdE5oM5TG6vuS_tk",
                "https://images-cdn.9gag.com/photo/a0QbDyd_700b.jpg",
                "https://ih1.redbubble.net/image.477297104.9491/flat,1000x1000,075,f.u1.jpg",
                "https://i.redd.it/24mhy5pv040z.jpg",
                "https://m.media-amazon.com/images/I/41DMdiSDBuL._AC_.jpg",
                "https://i1.wp.com/katzenworld.co.uk/wp-content/uploads/2019/06/funny-cat.jpeg?fit=1020%2C1020&ssl=1",
                "https://i.imgflip.com/3ktsod.jpg",
                "https://media.gettyimages.com/photos/funny-kittens-picture-id1138179540?s=612x612",
                "https://kellyloves.files.wordpress.com/2010/07/silly-animals.jpg?w=400",
                "https://cdn.discordapp.com/attachments/746365554989727877/821805571081633822/Snapchat-112264831.jpg"};

    public String getPlaceholder() {
        Random rand = new Random();
        System.out.println(placeholders.length);
        int randomInt = rand.nextInt(placeholders.length);

        return placeholders[randomInt];
    }

    public String getImagePlaceholder(){
        Random rand = new Random();
        System.out.println(imagePlaceholders.length);
        int randomInt = rand.nextInt(imagePlaceholders.length);

        return imagePlaceholders[randomInt];
    }
}
