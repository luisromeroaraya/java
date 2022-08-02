package com.example.demorest.tools;

import com.example.demorest.model.entities.Child;
import com.example.demorest.model.entities.Tutor;
import com.example.demorest.service.ChildService;
import com.example.demorest.service.TutorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class DataInit implements InitializingBean {

    private final ChildService childService;
    private final TutorService tutorService;
    private List<Child> children = Arrays.asList(
            new Child("Ben", "Affleck", LocalDate.of(2020,1,1), false, List.of("None")),
            new Child("Tom", "Cruise", LocalDate.of(2020,1,1), false, List.of("None")),
            new Child("Leonardo", "Di Caprio", LocalDate.of(2020,1,1), false, List.of("None"))
    );

    private List<Tutor> tutors = Arrays.asList(
            new Tutor("Scarlett", "Johansson", "0123456789", "Johansson Street 123, Brussels"),
            new Tutor("Jennifer", "Anniston", "0123456789", "Anniston Street 123, Ghent"),
            new Tutor("Julia", "Roberts", "0123456789", "Roberts Street 123, Antwerp")
    );

    public DataInit(ChildService childService, TutorService tutorService) {
        this.childService = childService;
        this.tutorService = tutorService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.children.forEach(this.childService::create);
        this.tutors.forEach(this.tutorService::create);
        for (long i = 1; i <= this.childService.getAll().toArray().length; i++) {
            long j = i+3;
            Child child = this.childService.getOne(i);
            child.setTutors(Set.of(tutorService.getOne(j)));
            childService.update(i, child);
        }
        for (long i = 1; i <= this.tutorService.getAll().toArray().length; i++) {
            long j = i+3;
            Tutor tutor = this.tutorService.getOne(j);
            tutor.setChildren(Set.of(childService.getOne(i)));
            tutorService.update(j, tutor);
        }

    }
}
