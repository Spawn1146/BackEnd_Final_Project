package com.ironhack.DnDCharacterSheet.DataLoader;

import com.ironhack.DnDCharacterSheet.Enum.Alignment;
import com.ironhack.DnDCharacterSheet.Enum.BasicRaces;
import com.ironhack.DnDCharacterSheet.Enum.MainClasses;
import com.ironhack.DnDCharacterSheet.Enum.StatType;
import com.ironhack.DnDCharacterSheet.Domain.*;
import com.ironhack.DnDCharacterSheet.Service.*;

import java.util.ArrayList;
import java.util.List;

public class CharacterLoader {

    public static MyCharacters loadCharacter(String name, BasicRaces race, String background, Alignment alignment, int level,
                                             MainClasses mainClass, String subClasses, StatType statType, int speed,
                                             int initiative, int armorClass, int hitDice, boolean inspiration,
                                             int proficiencyBonus, Pair<String, String> proficiencyST,
                                             List<String> proficiencies) {

        // Create the list of other proficiencies and languages based on the input
        List<OtherProficiencyOrLanguage> otherProficienciesAndLanguages = new ArrayList<>();
        for (String proficiency : proficiencies) {
            otherProficienciesAndLanguages.add(new OtherProficiencyOrLanguage(proficiency));
        }

        // Create the MyCharacters instance
        MyCharacters character = new MyCharacters(
                name, race, background, alignment, level, mainClass, subClasses, statType, speed, initiative, armorClass, hitDice,
                inspiration, proficiencyBonus
        );

        // Associate the proficiency saving throws pair
        character.setProficiencyST(proficiencyST);

        // Add other proficiencies and languages to character
        for (OtherProficiencyOrLanguage proficiency : otherProficienciesAndLanguages) {
            proficiency.setCharacter(character);
            character.addOtherProficiencyOrLanguage(proficiency);
        }

        return character;
    }
}