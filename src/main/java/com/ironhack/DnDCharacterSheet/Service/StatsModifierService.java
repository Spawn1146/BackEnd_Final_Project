package com.ironhack.DnDCharacterSheet.Service;

import com.ironhack.DnDCharacterSheet.DTO.StatsModifierDTO;
import com.ironhack.DnDCharacterSheet.Enum.StatType;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatsModifierService {

    // Method to calculate the modifier based on a stat value
    private int calculateModifier(int statValue) {
        return (statValue / 2) - 5;
    }

    // Method to create a StatsModifierDTO
    public StatsModifierDTO createStatsModifierDTO(Map<StatType, Integer> stats) {
        Map<StatType, Integer> modifiers = stats.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> calculateModifier(entry.getValue())));
        return new StatsModifierDTO(stats, modifiers);
    }
}