package com.ironhack.DnDCharacterSheet.DTO;

import com.ironhack.DnDCharacterSheet.Enum.StatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class StatsDTO {
    private Long statsId;
    private Map<StatType, Integer> values;

    // Constructor
    public StatsDTO(Long statsId, Map<StatType, Integer> values) {
        this.statsId = statsId;
        this.values = values;
    }

    // No need for equals, hashCode, toString unless specifically needed
}