package com.ironhack.DnDCharacterSheet.Repository;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Domain.MyCharacters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtherProficiencyOrLanguageRepository extends JpaRepository<OtherProficiencyOrLanguage, Long> {
    List<OtherProficiencyOrLanguage> findByCharacter(MyCharacters character);
}