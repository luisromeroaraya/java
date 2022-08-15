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
            new User("fred", new BCryptPasswordEncoder().encode("password"),"fred@mail.com","Fred", "Freddo ", "BE"),
            new User("marcelo", new BCryptPasswordEncoder().encode("password"),"marcelo@mail.com", "Marcelo", "Martins", "CL", List.of("ADMIN"))
    );

    private List<Place> places = Arrays.asList(
            new Place("Rock Classic", new Address("Rue du Marché au Charbon", 55, "1000", "Bruxelles", "Bruxelles-Capital", "BE", 50.8462272, 4.3463995), new Contact("025121547", "contact@rockclassic.be", "www.rockclassic.be", "https://www.facebook.com/rockclassic.bar.7/", "www.instagram.com/rockclassicbarbxl", "www.twitter.com/rockclassicbarbxl"), Type.BAR, users.get(0))
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        userRepository.saveAll(users);
        placeRepository.saveAll(places);
    }
}
