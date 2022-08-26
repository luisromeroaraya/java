package com.example.demorest.mapper;

import com.example.demorest.models.dto.UserDTO;
import com.example.demorest.models.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User entity) {
        if (entity == null)
            return null;
        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }
}
