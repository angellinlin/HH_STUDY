package com.spdb.resume.service;

import com.spdb.resume.common.CommonCode;
import com.spdb.resume.dao.ResumeRepository;
import com.spdb.resume.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {
    @Autowired
    ResumeRepository resumeRepository;

    public CommonCode addResume(Resume resume) {
        String id = resume.getId();
        Optional<Resume> resume1 = resumeRepository.findById(id);
        if (resume1.isPresent()) {
            return CommonCode.REPETID;
        } else {
            resumeRepository.save(resume);
            return CommonCode.ADDED;
        }
    }

    public CommonCode deleteResume(String id) {
        Optional<Resume> optional = resumeRepository.findById(id);
        if (optional.isPresent()) {
            Resume resume = optional.get();
            if (resume.getDeleteStatus() == 1) {
                resume.setDeleteStatus(0);
                resumeRepository.save(resume);
                return CommonCode.DELETED;
            } else {
                return CommonCode.NOTFOUND;
            }
        } else {
            return CommonCode.NOTFOUND;
        }
    }

    public CommonCode updateResume(Resume resume) {
        Optional<Resume> optional = resumeRepository.findById(resume.getId());
        if (optional.isPresent() && resume.getDeleteStatus() == 1) {
            resumeRepository.save(resume);
            return CommonCode.UPDATED;
        } else {
            return CommonCode.NOTFOUND;
        }
    }

    public List<Resume> queryResme() {
        List<Resume> all = resumeRepository.findAll();
        for (int i = 0; i < all.size(); i++){
            if (all.get(i).getDeleteStatus() != 1){
                all.remove(i);
            }
        }
        return all;
    }
}
