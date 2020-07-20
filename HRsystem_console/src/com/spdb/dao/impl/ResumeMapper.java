package com.spdb.dao.impl;

import com.spdb.common.Const;
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

    @Autowired
    DataSourceUtil dataSourceUtil;

    public int createResume(Resume resume){

        String sql = "INSERT INTO spdb_console_resume(name,id_card_number,school,major,sex,email,phone,status,create_time,update_time)"+
                "values(" + resume.getName() + "," + resume.getId() + "," + resume.getSchool() + "," + resume.getMajor() + "," + resume.getSex() +
                "," + resume.getEmail() + "," + resume.getPhone() + "," + resume.getStatus() + "," + now() + "," + now() + ")";
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

        String sql = "DELETE FROM spdb_console_resume WHERE id_card_num="+ id_card_num;
        try {
            if (dataSourceUtil.executeDelete(sql)){
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
     *@Description 查询简历从数据库
     *@return
     *@param
     **/
    public int updateResume(Resume resume){

        //String sql = "UPDATE "



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

    /**
     *@Author: A wei
     *@Description 判断选择
     *@return
     *@param
     **/
    private boolean checkResumeValid(String str,String type){

        switch (type){
            case Const.IDCARDNUMBER:{
                if (inqueryResumeByIdCardNum(str) > 0) return false;
                else return true;
            }
            case Const.PHONE:{
                if (inqueryResumeByPhone(str) > 0) return false;
                else return true;
            }
            case Const.EMAIL:{
                if (inqueryResumeByEmail(str) > 0) return false;
                else return true;
            }
            default: return false;
        }
    }

    /**
     *@Author: A wei
     *@Description 查询简历id_card_num是否注册
     *@return
     *@param
     **/
    public int inqueryResumeByIdCardNum(String id_card_num){

        String sql = "SELECT COUNT(1) FROM spdb_console_resume WHERE id_card_number =" + id_card_num;

        try {
            if (dataSourceUtil.executeInquery(sql))
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /**
     *@Author: A wei
     *@Description 查询简历phone是否注册
     *@return
     *@param
     **/
    public int inqueryResumeByPhone(String phone){

        String sql = "SELECT COUNT(1) FROM spdb_console_resume WHERE phone =" + phone;

        try {
            if (dataSourceUtil.executeInquery(sql))
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /**
     *@Author: A wei
     *@Description 查询简历email是否注册
     *@return
     *@param
     **/
    public int inqueryResumeByEmail(String email){

        String sql = "SELECT COUNT(1) FROM spdb_console_resume WHERE email =" + email;

        try {
            if (dataSourceUtil.executeInquery(sql))
                return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

}
