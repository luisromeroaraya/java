package com.example.demorest.tools;

import com.example.demorest.exceptions.ElementNotFoundException;
import com.example.demorest.models.entities.Child;
import com.example.demorest.models.entities.Tutor;
import com.example.demorest.models.forms.ChildAddForm;
import com.example.demorest.models.forms.TutorAddForm;
import com.example.demorest.repositories.ChildRepository;
import com.example.demorest.repositories.TutorRepository;
import com.example.demorest.services.ChildService;
import com.example.demorest.services.TutorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataInit implements InitializingBean {

    private final ChildService childService;
    private final TutorService tutorService;
    private final ChildRepository childRepository;
    private final TutorRepository tutorRepository;
    private List<Tutor> tutors = Arrays.asList(
            new Tutor("Scarlett", "Johansson", "0123456789", "Johansson Street 123, Brussels"),
            new Tutor("Jennifer", "Anniston", "0123456789", "Anniston Street 123, Ghent"),
            new Tutor("Julia", "Roberts", "0123456789", "Roberts Street 123, Antwerp")
    );
    private List<Child> children = Arrays.asList(
            new Child("Ben", "Affleck", LocalDate.of(2020,1,1), false, List.of("None"), Set.of(tutors.get(0))),
            new Child("Tom", "Cruise", LocalDate.of(2020,1,1), false, List.of("None"), Set.of(tutors.get(1))),
            new Child("Leonardo", "Di Caprio", LocalDate.of(2020,1,1), false, List.of("None"), Set.of(tutors.get(2)))
            );

    public DataInit(ChildService childService, TutorService tutorService, ChildRepository childRepository, TutorRepository tutorRepository) {
        this.childService = childService;
        this.tutorService = tutorService;
        this.childRepository = childRepository;
        this.tutorRepository = tutorRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        tutorRepository.saveAll(tutors);
        childRepository.saveAll(children);
    }
}
