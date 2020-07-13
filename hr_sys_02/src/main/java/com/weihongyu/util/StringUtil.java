package com.weihongyu.util;

import com.weihongyu.entity.Resume;

import java.lang.reflect.Type;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 11:41
 * @Description:
 */
public class StringUtil {

    public static Resume strToResume(String str){
        String[] values = str.split("#");
        Resume resume = new Resume();

        resume.setName(values[0]);
        resume.setId(values[1]);
        resume.setSchool(values[2]);

        return resume;
    }
}
