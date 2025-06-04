package com.data.ss19.repository.bt3;

import com.data.ss19.entity.bt3.Theater;
import java.util.List;

public interface TheaterRepository {
    List<Theater> getAllTheaters(int page, int size);
    int getCountTheaters();
    Theater getTheaterById(long id);
    void saveTheater(Theater theater);
    void deleteTheater(long id);
    List<Theater> searchTheaters(String keyword, int page, int size);
    int getCountSearchTheaters(String keyword);
    void updateTheater(Theater theater);
    Theater findById(Long id);
    List<Theater> findByStatus(Boolean status);
}
