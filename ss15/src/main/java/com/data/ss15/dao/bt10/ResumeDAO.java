package com.data.ss15.dao.bt10;

import com.data.ss15.model.bt10.Resume;

import java.util.List;

public interface ResumeDAO {
    void addResume(Resume resume);
    List<Resume> getAllResumes();
    void deleteResume(Long id);
}

