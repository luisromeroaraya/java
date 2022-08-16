package com.example.demospring.services;

import com.example.demospring.models.dto.PlayerDTO;
import com.example.demospring.models.entities.Player;
import com.example.demospring.mapper.Mapper;
import com.example.demospring.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService implements IService<Player, PlayerDTO, Long>{
    private final PlayerRepository playerRepository;
    private final Mapper mapper;

    public PlayerService(PlayerRepository playerRepository, Mapper mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }


    @Override
    public List<PlayerDTO> getAll() {
        return this.playerRepository
                .findAll()
                .stream()
                .sorted((a,b) -> a.getPosition().compareTo(b.getPosition()))
                .map(mapper::toPlayerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getById(Long id) {
        Optional<Player> player = this.playerRepository.findById(id);
        return player.map(this.mapper::toPlayerDTO).orElse(null);
    }

    @Override
    public boolean update(Long id, Player entity) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public PlayerDTO insert(Player entity) {
        if(entity != null){
            Player newPlayer = this.playerRepository.save(entity);
            return this.mapper.toPlayerDTO(newPlayer);
        }
        else {
            throw new RuntimeException("Error! Invalid player.");
        }
    }
}
