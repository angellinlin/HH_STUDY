package com.weihongyu;

import com.weihongyu.controller.ResumeController;

import java.sql.SQLException;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 12:22
 * @Description:jdbc版本HR系统入口程序
 */
public class HR_sys_jdbc {

    public static void main(String[] args) throws SQLException {
        ResumeController resumeController = new ResumeController();
        resumeController.run();
    }
}
