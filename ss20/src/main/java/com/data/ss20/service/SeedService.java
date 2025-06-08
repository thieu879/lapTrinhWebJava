package com.data.ss20.service;

import com.data.ss20.entity.Seed;

import java.util.List;

public interface SeedService {
    List<Seed> getSeeds();
    Seed getSeedById(Long id);
    void saveSeed(Seed seed);
    void updateSeed(Seed seed);
    void deleteSeed(Long id);
    List<Seed> searchSeeds(String keyword);
}
