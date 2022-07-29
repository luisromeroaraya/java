package com.example.demorest.tools;

import com.example.demorest.model.entities.Child;
import com.example.demorest.service.ChildService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final ChildService service;
    private List<Child> children = Arrays.asList(
            new Child("Ben", "Affleck", LocalDate.of(2020,1,1), false, List.of("None")),
            new Child("Tom", "Cruise", LocalDate.of(2020,1,1), false, List.of("None")),
            new Child("Leonardo", "Di Caprio", LocalDate.of(2020,1,1), false, List.of("None"))
    );

    public DataInit(ChildService service) {
        this.service = service;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.children.forEach(this.service::save);
    }
}
