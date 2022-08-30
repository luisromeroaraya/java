package com.metaltravelguide.places.tools;

import com.metaltravelguide.places.models.entities.*;
import com.metaltravelguide.places.repositories.PlaceRepository;
import com.metaltravelguide.places.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    public DataInit(UserRepository userRepository, PlaceRepository placeRepository) {
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
    }

    private List<User> users = Arrays.asList(
            new User("marcelo", new BCryptPasswordEncoder().encode("password"),"marcelo@mail.com", "Marcelo", "Martins", "CL", List.of("ADMIN")),
            new User("fred", new BCryptPasswordEncoder().encode("password"),"fred@mail.com","Fred", "Freddo ", "BE")
    );

    private List<Place> places = Arrays.asList(
            new Place("Rock Classic", new Address("Rue du Marché au Charbon", 55, "1000", "Bruxelles", "Bruxelles-Capital", "BE", 50.8462272, 4.3463995), new Contact("+3225121547", "contact@rockclassic.be", "www.rockclassic.be", "https://www.facebook.com/rockclassic.bar.7/", "www.instagram.com/rockclassicbarbxl", "www.twitter.com/rockclassicbarbxl"), Type.BAR, "The Rock Classic cafe is one of the best venues in the city to enjoy rock music. The cool ambience, lively resident DJs, electrifying music and friendly service will give you a pleasant experience. The bar also organises concerts, performances, and other musical events for rock music lovers.", "/images/Rock-Classic-Bxl.png", users.get(1)),
            new Place("Rainbow Bar & Grill", new Address("Sunset Blvd", 9015, "","West Hollywood", "California", "US", 34.0908937, -118.3903889), new Contact("+13102784232", "contact@rainbowbarandgrill.com", "https://www.rainbowbarandgrill.com/", "https://www.facebook.com/pages/RAINBOW-BAR-AND-GRILL/196112625090", "http://instagram.com/rainbowbarandgrill", "http://twitter.com/rainbowlive"), Type.BAR, "This iconic bar on the Sunset Strip is both a living museum of metal’s glory days and a still very active hot spot for metal fans and musicians. Since 1973, every great in metal and hard rock has hung out at this delightfully stuck-in-time restaurant and bar. Bands have met and formed between the carpeted lounge areas and the parking lot after shows at nearby venues. Members of Guns N’ Roses and Motley Crue have their own booths. The walls are covered in signed memorabilia. At the patio bar, the corner stool has a plaque and next to it, a full-sized statue of Lemmy: This is where Motörhead’s legendary frontman would sit playing video poker and drinking Jack and Cokes. Upstairs, there’s a raised nook that is often occupied by music V.I.P.s, but if it’s empty, take a look at the wooden sign on its railing. This was the treehouse-like hideaway for the 'Hollywood Vampires', a club formed by Alice Cooper, Keith Moon, John Lennon, Ringo Starr, Harry Nilsson and Micky Dolenz.", "/images/Rainbow-Bar-Grill.png", users.get(0)),
            new Place("Neseblod Records", new Address("Schweigaards Gate", 56, "","Oslo", "Østlandet", "NO", 59.9085014, 10.7677383), new Contact("+4798135278", "neseblod@neseblodrecords.com", "https://neseblodrecords.bigcartel.com/", "https://www.facebook.com/neseblodrecords/", "https://www.instagram.com/neseblod_records_666/", "https://twitter.com/neseblodlabel"), Type.HISTORIC, "As the birthplace of metal’s most notorious subgenre, Norway should top the pilgrimage list of every headbanger. Black metal’s origin point can be traced directly to Neseblod Records, formerly known as Helvete. Norwegian for 'hell', Helvete was run by Øystein Aarseth — Euronymous, the guitarist and founding member for Mayhem. Helvete sold the heaviest albums from around the world, attracting metalheads who created a new scene and formed black metal bands in and around Oslo. (The shop has a big role in this year’s Lords of Chaos film.) You can still find an incredible selection of albums spanning the genres of metal here, both renowned and unheard of, but you’ll also find a ton of rare metal merch and, best of all, the walls are a sort of museum for not-for-sale black metal artifacts such as letters from Euronymous and Darkthrone demos. And don’t forget to head down to the basement and take a photo in front of the iconic “Black Metal” wall where the genre’s pioneers took group photos.", "/images/Neseblod-Records.png", users.get(0)),
            new Place("Sverd i Fjell", new Address("Madlaveien", 366, "","Stavanger", "Vestlandet", "NO", 59.1386358, 6.4979366), new Contact("+4751859200", "info@regionstavanger.com", "https://www.fjordnorway.com/en/see-and-do/swords-in-rock", "https://www.facebook.com/stavangerkommune/", "https://www.instagram.com/stavangerkommune/", "https://twitter.com/kommunen"), Type.HISTORIC, "Swords in Rock in english, is a commemorative monument located in the Hafrsfjord neighborhood of Madla, a borough of the city of Stavanger which lies in the southwestern part of the large municipality of Stavanger in Rogaland county, Norway.", "/images/Sverd-i-Fjell.png", users.get(0)),
            new Place("The Hellfest Lemmy Statue", new Address("Rue du Champ Louet", 0, "Warzone Stage","Clisson", "Pays de la Loire", "FR", 47.0978224, -1.2655573), new Contact("+33251887950", " info@hellfest.fr", "https://www.hellfest.fr/", "https://www.facebook.com/hellfest/", "https://www.instagram.com/hellfestopenair/", "https://twitter.com/hellfestopenair"), Type.HISTORIC, "Making sure that France's Hellfest will always have a Lemmy presence, festival organizers have revealed a new statue for this year's edition that replaces the old one that had been in place. Following the Motorhead frontman's death in 2015, organizers decided to have a sculpture created to honor the musician at their festival, and the initial piece went up six years ago, but had started to suffer some plaster crumbling. The new sculpture was the work of artist Caroline Brisset, who accepted the challenge of making the new Lemmy statue for the Hellfest in Clisson, France. A portion of Lemmy's ashes are enshrined in this monument.", "/images/Lemmy-Statue.png", users.get(0)),
            new Place("The Abyss", new Address("Andra Långgatan", 35, "","Göteborg", "Västergötland", "SE", 57.6988917, 11.9425334), new Contact("+46733497587", "", "https://theabyss.se/", "https://www.facebook.com/theabyssgbg/", "https://www.instagram.com/theabyssgbg/", ""), Type.BAR, "Home of At The Gates, Dark Tranquility and In Flames, Gothenburg has its own special place in the landscape of Swedish death metal. Often referred to as 'the Gothenburg sound', this picturesque city lined with cobblestoned streets gave the head-banging world a melodic take and now, whether you like your death metal melodic or not, Gothenburg remains a destination with metal cred. The Abyss is at the center of this reputation. This bar is essentially wallpapered in concert fliers, and actually hosts its own concerts on the regular. Like other metal hubs in other cities, The Abyss is a certified after-show spot and a guaranteed way to bond with metalheads from other countries while you sip beer and eat pizza.", "/images/The-Abyss.png", users.get(0)),
            new Place("Fantoft Stave Church", new Address("Fantoftvegen", 38, "","Bergen", "Vestland", "NO", 60.3393057, 5.3511013), new Contact("+4755280710", "post@fantoftstavkirke.no", "https://fantoftstavkirke.no/", "https://www.facebook.com/Fantoft-Stavkirke-116279061789665/", "https://www.instagram.com/fantoft_stavkirke/", ""), Type.HISTORIC, "Fantoft Stave Church in Bergen Norway suffered a terrible fate in April of 1992 when it was burned down by Varg Vikernes, a member of the Norwegian black metal band Mayhem and one-man music project Burzum. The Fantoft Stave Church burning had started the war between Norwegian churches vs black metal in Norway.", "/images/Fantoft-Church.png", users.get(0))
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        userRepository.saveAll(users);
        placeRepository.saveAll(places);
    }
}
