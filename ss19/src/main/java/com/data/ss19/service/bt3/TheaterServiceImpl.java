package com.data.ss19.service.bt3;

import com.data.ss19.entity.bt3.Theater;
import com.data.ss19.repository.bt3.TheaterRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService {
    private TheaterRepository theaterRepository;
    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }
    @Override
    public void deleteTheater(long id) {
        theaterRepository.deleteTheater(id);
    }

    @Override
    public List<Theater> getAllTheaters(int page, int size) {
        return theaterRepository.getAllTheaters(page, size);
    }

    @Override
    public int getCountTheaters() {
        return theaterRepository.getCountTheaters();
    }

    @Override
    public Theater getTheaterById(long id) {
        return theaterRepository.getTheaterById(id);
    }

    @Override
    public void saveTheater(Theater theater) {
        theaterRepository.saveTheater(theater);
    }

    @Override
    public List<Theater> searchTheaters(String keyword, int page, int size) {
        return theaterRepository.searchTheaters(keyword, page, size);
    }

    @Override
    public int getCountSearchTheaters(String keyword) {
        return theaterRepository.getCountSearchTheaters(keyword);
    }

    @Override
    public void updateTheater(Theater theater) {
        theaterRepository.updateTheater(theater);
    }

    @Override
    public Theater findById(Long id) {
        return theaterRepository.findById(id);
    }

    @Override
    public List<Theater> findByStatus(Boolean status) {
        return theaterRepository.findByStatus(status);
    }
}
