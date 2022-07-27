package com.example.demospring.utils;

import com.example.demospring.entities.Player;
import com.example.demospring.services.PlayerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final PlayerService playerService;
    private List<Player> players = Arrays.asList(
            Player.builder()
                    .name("Ronaldo")
                    .birthdate(LocalDate.of(1980, 1, 1))
                    .number(9).position(Position.ST)
                    .salary(1500000.00)
                    .build(),
            Player.builder()
                    .name("Ronaldinho")
                    .birthdate(LocalDate.of(1980, 1, 1))
                    .number(11).position(Position.CAM)
                    .salary(1300000.00)
                    .build(),
            Player.builder()
                    .name("Roberto Carlos")
                    .birthdate(LocalDate.of(1980, 1, 1))
                    .number(6).position(Position.LB)
                    .salary(1000000.00)
                    .build(),
            Player.builder()
                    .name("Cafú")
                    .birthdate(LocalDate.of(1980, 1, 1))
                    .number(2).position(Position.RB)
                    .salary(1000000.00)
                    .build(),
            Player.builder()
                    .name("Lucio")
                    .birthdate(LocalDate.of(1980, 1, 1))
                    .number(3).position(Position.CB)
                    .salary(1100000.00)
                    .build(),
            Player.builder()
                    .name("Dida")
                    .birthdate(LocalDate.of(1980, 1, 1))
                    .number(12).position(Position.GK)
                    .salary(800000.00)
                    .build()
    );

    public DataInit(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.players.forEach(this.playerService::insert);
    }
}
