package com.ironhack.DnDCharacterSheet.Controller;

import com.ironhack.DnDCharacterSheet.DTO.StatsDTO;
import com.ironhack.DnDCharacterSheet.Service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    // Get all stats
    @GetMapping
    public List<StatsDTO> getAllStats() {
        return statsService.getAllStats();
    }

    // Get stats by ID
    @GetMapping("/{id}")
    public StatsDTO getStatsById(@PathVariable Long id) {
        return statsService.getStatsById(id);
    }

    // Create new stats
    @PostMapping
    public StatsDTO createStats(@RequestBody StatsDTO statsDTO) {
        return statsService.createStats(statsDTO);
    }

    // Update existing stats
    @PutMapping("/{id}")
    public StatsDTO updateStats(@PathVariable Long id, @RequestBody StatsDTO statsDTO) {
        statsDTO.setStatsId(id);
        return statsService.updateStats(statsDTO);
    }

    // Delete stats by ID
    @DeleteMapping("/{id}")
    public void deleteStats(@PathVariable Long id) {
        statsService.deleteStats(id);
    }
}