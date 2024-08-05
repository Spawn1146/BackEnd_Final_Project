package com.ironhack.DnDCharacterSheet.Domain;

import com.ironhack.DnDCharacterSheet.Enum.Alignment;
import com.ironhack.DnDCharacterSheet.Enum.BasicRaces;
import com.ironhack.DnDCharacterSheet.Enum.MainClasses;
import com.ironhack.DnDCharacterSheet.Enum.StatType;

import java.util.HashMap;
import java.util.Map;

public class StatsModifier {

    // Method to calculate the modifier based on a stat value
    public static int calculateModifier(int statValue) {
        return (statValue / 2) - 5;
    }

    public static void main(String[] args) {
        // Create a map to represent the stats
        Map<StatType, Integer> statsMap = new HashMap<>();
        statsMap.put(StatType.STRENGTH, 15);
        statsMap.put(StatType.DEXTERITY, 12);
        statsMap.put(StatType.CONSTITUTION, 14);
        statsMap.put(StatType.INTELLIGENCE, 10);
        statsMap.put(StatType.WISDOM, 16);
        statsMap.put(StatType.CHARISMA, 8);

        // Create a Stats instance
        Stats characterStats = new Stats(statsMap);

        // Create a MyCharacters instance with stat values (example values)
        MyCharacters myCharacter = new MyCharacters(
                "John Doe", BasicRaces.HUMAN, "Farmer", Alignment.NEUTRAL, 1,
                MainClasses.BARBARIAN, "None", StatType.STRENGTH, 30, 2, 15, 1, false, 2);
        myCharacter.setStats(statsMap);

        // Access the stat values using the stats map
        int strength = myCharacter.getStats().get(StatType.STRENGTH);
        int dexterity = myCharacter.getStats().get(StatType.DEXTERITY);
        int constitution = myCharacter.getStats().get(StatType.CONSTITUTION);
        int intelligence = myCharacter.getStats().get(StatType.INTELLIGENCE);
        int wisdom = myCharacter.getStats().get(StatType.WISDOM);
        int charisma = myCharacter.getStats().get(StatType.CHARISMA);

        // Calculate the modifiers for each stat
        int modifierStr = calculateModifier(strength);
        int modifierDex = calculateModifier(dexterity);
        int modifierCon = calculateModifier(constitution);
        int modifierInt = calculateModifier(intelligence);
        int modifierWis = calculateModifier(wisdom);
        int modifierCha = calculateModifier(charisma);

        // Print the modifiers
        System.out.println("Strength Modifier: " + modifierStr);
        System.out.println("Dexterity Modifier: " + modifierDex);
        System.out.println("Constitution Modifier: " + modifierCon);
        System.out.println("Intelligence Modifier: " + modifierInt);
        System.out.println("Wisdom Modifier: " + modifierWis);
        System.out.println("Charisma Modifier: " + modifierCha);
    }
}