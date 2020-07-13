package com.spdb.resume.controller;

import com.spdb.resume.api.Resume.ResumeControllerApi;
import com.spdb.resume.common.CommonCode;
import com.spdb.resume.model.Resume;
import com.spdb.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController implements ResumeControllerApi {
    @Autowired
    ResumeService resumeService;

    //增加简历
    @Override
    @PostMapping("/add")
    public CommonCode addResume(@RequestBody Resume resume) {
        System.out.println(resume);
        return resumeService.addResume(resume);
    }

    //根据id删除简历
    @Override
    @PostMapping("/delete")
    public CommonCode deleteResume(@RequestParam("id") String id) {
        return resumeService.deleteResume(id);
    }

    //根据id修改简历
    @Override
    @PostMapping("/update")
    public CommonCode updateResume(@RequestBody Resume resume) {
        return resumeService.updateResume(resume);
    }

    //遍历全部简历
    @Override
    @PostMapping("/query")
    public List<Resume> queryResme() {
        return resumeService.queryResme();
    }

}
