package com.ironhack.DnDCharacterSheet.Controller;

import com.ironhack.DnDCharacterSheet.DTO.StatsModifierDTO;
import com.ironhack.DnDCharacterSheet.Enum.StatType;
import com.ironhack.DnDCharacterSheet.Service.StatsModifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/stats-modifier")
public class StatsModifierController {

    @Autowired
    private StatsModifierService statsModifierService;

    // Endpoint to calculate modifiers for given stats
    @PostMapping("/calculate")
    public StatsModifierDTO calculateModifiers(@RequestBody Map<StatType, Integer> stats) {
        return statsModifierService.createStatsModifierDTO(stats);
    }
}