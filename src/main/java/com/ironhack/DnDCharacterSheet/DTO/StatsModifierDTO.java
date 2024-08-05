package com.ironhack.DnDCharacterSheet.DTO;

import com.ironhack.DnDCharacterSheet.Enum.StatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class StatsModifierDTO {
    private Map<StatType, Integer> stats;
    private Map<StatType, Integer> modifiers;

    // Constructor
    public StatsModifierDTO(Map<StatType, Integer> stats, Map<StatType, Integer> modifiers) {
        this.stats = stats;
        this.modifiers = modifiers;
    }
}