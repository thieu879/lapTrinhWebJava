package com.data.ss20.service;

import com.data.ss20.entity.Seed;
import com.data.ss20.repository.SeedRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SeedServiceImpl implements SeedService {
    private SeedRepository seedRepository;
    public  SeedServiceImpl(SeedRepository seedRepository) {
        this.seedRepository = seedRepository;
    }
    @Override
    public void deleteSeed(Long id) {
        seedRepository.deleteSeed(id);
    }

    @Override
    public List<Seed> getSeeds() {
        return seedRepository.getSeeds();
    }

    @Override
    public Seed getSeedById(Long id) {
        return seedRepository.getSeedById(id);
    }

    @Override
    public void saveSeed(Seed seed) {
        seedRepository.saveSeed(seed);
    }

    @Override
    public void updateSeed(Seed seed) {
        seedRepository.updateSeed(seed);
    }

    @Override
    public List<Seed> searchSeeds(String keyword) {
        return seedRepository.searchSeeds(keyword);
    }
}
