package com.ironhack.DnDCharacterSheet.ClassesBonus;

import com.ironhack.DnDCharacterSheet.Domain.OtherProficiencyOrLanguage;
import com.ironhack.DnDCharacterSheet.Service.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class IfBard {   // DEX, CHA - Light Armor, Simple weapons, hand crossbows, longswords, rapiers, shortswords, 3 instruments, 3 skills

    public Pair<String, String> getProficiencySavingThrows() {
        return new Pair<>("dexterity", "charisma");
    }

    public List<String> getProficienciesAndLanguages() {
        List<String> proficiencies = new ArrayList<>();
        proficiencies.add("Light Armor");
        proficiencies.add("Simple Weapons");
        proficiencies.add("Hand Crossbows");
        proficiencies.add("Longswords");
        proficiencies.add("Rapiers");
        proficiencies.add("Shortswords");
        return proficiencies;
    }

    public List<String> selectInstruments() {
        String[] instrumentOptions = {
                "Bagpipes", "Drum", "Dulcimer", "Flute", "Lute", "Lyre",
                "Horn", "Pan flute", "Shawm", "Viol"
        };

        // For simplicity, select the first three instruments
        List<String> selectedInstruments = new ArrayList<>();
        selectedInstruments.add(instrumentOptions[0]);
        selectedInstruments.add(instrumentOptions[1]);
        selectedInstruments.add(instrumentOptions[2]);

        return selectedInstruments;
    }

    public List<String> selectSkills() {
        String[] skillOptions = {
                "Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "History",
                "Insight", "Intimidation", "Investigation", "Medicine", "Nature", "Perception",
                "Performance", "Persuasion", "Religion", "Sleight of Hand", "Stealth", "Survival"
        };

        // For simplicity, select the first three skills
        List<String> selectedSkills = new ArrayList<>();
        selectedSkills.add(skillOptions[0]);
        selectedSkills.add(skillOptions[1]);
        selectedSkills.add(skillOptions[2]);

        return selectedSkills;
    }
}