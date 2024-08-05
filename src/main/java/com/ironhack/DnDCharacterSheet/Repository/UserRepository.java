package com.ironhack.DnDCharacterSheet.Repository;

import com.ironhack.DnDCharacterSheet.Domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}