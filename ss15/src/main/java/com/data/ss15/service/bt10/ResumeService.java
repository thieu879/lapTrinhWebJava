package com.data.ss15.service.bt10;

import com.data.ss15.model.bt10.Resume;

import java.util.List;

public interface ResumeService {
    void addResume(Resume resume);
    List<Resume> getAllResumes();
    void deleteResume(Long id);
}
