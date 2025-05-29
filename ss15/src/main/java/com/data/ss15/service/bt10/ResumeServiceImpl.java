package com.data.ss15.service.bt10;

import com.data.ss15.dao.bt10.ResumeDAO;
import com.data.ss15.dao.bt10.ResumeDAOImpl;
import com.data.ss15.model.bt10.Resume;

import java.util.List;

public class ResumeServiceImpl implements ResumeService {
    private ResumeDAO resumeDAO = new ResumeDAOImpl();

    @Override
    public void addResume(Resume resume) {
        resumeDAO.addResume(resume);
    }

    @Override
    public List<Resume> getAllResumes() {
        return resumeDAO.getAllResumes();
    }

    @Override
    public void deleteResume(Long id) {
        resumeDAO.deleteResume(id);
    }
}

