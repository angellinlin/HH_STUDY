package com.spdb.dao;

import com.spdb.common.ServerResponse;
import com.spdb.pojo.Resume;

/**
 * @Author: A wei
 * @Date: 2020/7/14 15:01
 * @Last Modified by:
 * @last Modified date:
 * @Description: dao对象负责对数据库操作
 */
public interface IResumeMapper {

   int createResume(Resume resume);

   int deleteResume(String id_card_num);

   int updateResume(Resume resume);

   ServerResponse<Resume> selectResume(String id_card_num);
}
