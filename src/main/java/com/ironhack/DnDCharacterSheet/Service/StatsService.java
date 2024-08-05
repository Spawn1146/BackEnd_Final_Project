package com.ironhack.DnDCharacterSheet.Service;

import com.ironhack.DnDCharacterSheet.DTO.StatsDTO;
import com.ironhack.DnDCharacterSheet.Domain.Stats;
import com.ironhack.DnDCharacterSheet.Repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    private StatsDTO convertToDTO(Stats stats) {
        return new StatsDTO(stats.getStatsId(), stats.getValues());
    }

    private Stats convertToEntity(StatsDTO statsDTO) {
        return new Stats(statsDTO.getValues());
    }

    public List<StatsDTO> getAllStats() {
        List<Stats> statsList = statsRepository.findAll();
        return statsList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public StatsDTO getStatsById(Long id) {
        Optional<Stats> stats = statsRepository.findById(id);
        return stats.map(this::convertToDTO).orElse(null);
    }

    public StatsDTO createStats(StatsDTO statsDTO) {
        Stats stats = convertToEntity(statsDTO);
        stats = statsRepository.save(stats);
        return convertToDTO(stats);
    }

    public StatsDTO updateStats(StatsDTO statsDTO) {
        Stats stats = convertToEntity(statsDTO);
        stats = statsRepository.save(stats);
        return convertToDTO(stats);
    }

    public void deleteStats(Long id) {
        statsRepository.deleteById(id);
    }
}