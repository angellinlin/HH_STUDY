package com.spdb.resume.api.Resume;

import com.spdb.resume.common.CommonCode;
import com.spdb.resume.model.Resume;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value = "简历管理接口",description = "提供用户的增删改查")
public interface ResumeControllerApi {
    @ApiOperation("增加简历")
    public CommonCode addResume(Resume resume);

    @ApiOperation("根据id删除简历")
    public CommonCode deleteResume(String id);

    @ApiOperation("根据id修改简历")
    public CommonCode updateResume(Resume resume);

    @ApiOperation("查询所有简历")
    public List<Resume> queryResme();
}
