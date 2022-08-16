package com.example.demospring.mapper;

import com.example.demospring.models.dto.PlayerDTO;
import com.example.demospring.models.entities.Player;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class Mapper {
    public PlayerDTO toPlayerDTO(Player entity) {

        return PlayerDTO.builder()
                .id(entity.getId())
                .birthdate(entity.getBirthdate())
                .name(entity.getName())
                .number(entity.getNumber())
                .position(entity.getPosition())
                .salary(entity.getSalary())
                .age(Period.between(entity.getBirthdate(), LocalDate.now()).getYears())
                .build();
    }

    public Player toPlayerEntity(PlayerDTO dto) {
        return Player.builder()
                .id(dto.getId())
                .birthdate(dto.getBirthdate())
                .name(dto.getName())
                .number(dto.getNumber())
                .position(dto.getPosition())
                .salary(dto.getSalary())
                .build();
    }
}
