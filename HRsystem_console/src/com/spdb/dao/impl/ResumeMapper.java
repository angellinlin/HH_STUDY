package com.spdb.dao.impl;

import com.spdb.common.ServerResponse;
import com.spdb.dao.IResumeMapper;
import com.spdb.pojo.Resume;
import com.spdb.util.DataSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

import static java.time.LocalDate.now;

/**
 * @Author: A wei
 * @Date: 2020/7/14 14:57
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
@Component
public class ResumeMapper implements IResumeMapper {

 
    public int createResume(Resume resume){

        String sql = "INSERT INTO spdb_console_resume(name,id_card_number,school,major,sex,email,phone,status,create_time,update_time)"+
                "values(" + resume.getName() + "," + resume.getId() + "," + resume.getSchool() + "," + resume.getMajor() + "," + resume.getSex() +
                "," + resume.getEmail() + "," + resume.getPhone() + "," + resume.getStatus() + "," + now() + "," + now() + ")";
        //1、查询id、邮箱是否被注册

        try {
            if (dataSourceUtil.executeCreate(sql)){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /**
     *@Author: A wei
     *@Description 删除简历从数据库
     *@return
     *@param
     **/
    public int deleteResume(String id_card_num){
        //1、查询
        String sql = "DELETE FROM spdb_console_resume WHERE id_card_num="+ id_card_num;




        return 0;
    }

    /**
     *@Author: A wei
     *@Description 查询简历从数据库
     *@return
     *@param
     **/
    public int updateResume(Resume resume){
        return 0;
    }

    /**
     *@Author: A wei
     *@Description 查询简历从数据库
     *@return
     *@param
     **/
    public ServerResponse<Resume> selectResume(String id_card_num){
        //1、组合sql
        String sql = "SELECT * FROM spdb_console_resume WHERE id_card_number =" + id_card_num;
        Resume resume = null;
        try {
            resume = dataSourceUtil.executeSelect(sql);
            if (resume == null){
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ServerResponse.createBySuccess(resume);
    }

}
