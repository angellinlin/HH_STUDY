package com.spdb.resume.dao;

import com.spdb.resume.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume,String>{
    //根据id查找用户
    Optional<Resume> findById(String id);

    @Override
    List<Resume> findAll();
}
