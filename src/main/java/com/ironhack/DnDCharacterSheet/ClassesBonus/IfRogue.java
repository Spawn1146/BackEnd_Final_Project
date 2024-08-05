package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IfRogue {   // DEX, INT - Light Armor, Simple Weapons, Hand Crossbows, Longswords, Rapiers, Shortswords, Thieves’ Tools, 4 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("dexterity", "intelligence");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Light Armor");
        proficiencies.add("Simple Weapons");
        proficiencies.add("Hand Crossbows");
        proficiencies.add("Longswords");
        proficiencies.add("Rapiers");
        proficiencies.add("Shortswords");
        proficiencies.add("Thieves’ Tools");
        return proficiencies;
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Acrobatics", "Athletics", "Deception", "Insight", "Intimidation", "Investigation", "Perception", "Performance", "Persuasion", "Sleight of Hand", "Stealth"
        };

        // For simplicity, select the first four skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);
        selectedSkills.add(skillOptions[2]);
        selectedSkills.add(skillOptions[3]);

        return selectedSkills;
    }
}