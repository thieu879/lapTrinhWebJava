package com.data.ss20.repository;

import com.data.ss20.entity.Seed;

import java.util.List;

public interface SeedRepository {
    List<Seed> getSeeds();
    Seed getSeedById(Long id);
    void saveSeed(Seed seed);
    void updateSeed(Seed seed);
    void deleteSeed(Long id);
    List<Seed> searchSeeds(String keyword);
}
