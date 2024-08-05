package com.ironhack.DnDCharacterSheet.Repository;

import com.ironhack.DnDCharacterSheet.Domain.MyCharacters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCharactersRepository extends JpaRepository<MyCharacters, Long> {
    // Additional query methods if needed
}