package com.example.demorest.tools;

import com.example.demorest.models.entities.Address;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.entities.User;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class DataInit implements InitializingBean {
    private final ChildRepository childRepository;
    private final TutorRepository tutorRepository;
    private final UserRepository userRepository;

    public DataInit(ChildRepository childRepository, TutorRepository tutorRepository, UserRepository userRepository) {
        this.childRepository = childRepository;
        this.tutorRepository = tutorRepository;
        this.userRepository = userRepository;
    }

    private final List<Tutor> tutors = Arrays.asList(
            new Tutor("Scarlett", "Johansson", "0123456789", new Address("Johansson Street", 123, "1E", "Brussels", "Brussels-Capital", 1000)),
            new Tutor("Jennifer", "Anniston", "0123456789",  new Address("Anniston Street", 123, "2E", "Brussels", "Brussels-Capital", 1000)),
            new Tutor("Julia", "Roberts", "0123456789",  new Address("Roberts Street", 123, "3E", "Ostend", "West Flanders", 8400))
    );
    private final List<Child> children = Arrays.asList(
            new Child("Ben", "Affleck", LocalDate.of(2020,1,1), false, List.of("peanut", "aspirin"), Set.of(tutors.get(0))),
            new Child("Tom", "Cruise", LocalDate.of(2020,1,1), false, List.of("egg"), Set.of(tutors.get(1))),
            new Child("Leonardo", "Di Caprio", LocalDate.of(2020,1,1), false, List.of("peanut", "apple"), Set.of(tutors.get(2)))
    );

    private final List<User> users = Arrays.asList(
            new User("user", new BCryptPasswordEncoder().encode("password"), true, List.of("USER")),
            new User("admin", new BCryptPasswordEncoder().encode("password"), true, List.of("ADMIN"))
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        tutorRepository.saveAll(tutors);
        childRepository.saveAll(children);
        userRepository.saveAll(users);
    }
}
