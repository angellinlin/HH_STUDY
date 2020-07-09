package service;

import bean.Resume;

import java.util.ArrayList;

/**
 * @program: HR_SYS
 * @description: CRUD
 * @author: 朱戈
 * @create: 2020-07-09
 **/
public interface CRUDService {
    public void addEntity(ArrayList<Resume> entityList,Resume resume);

    public void deleteEntity(ArrayList<Resume> entityList,String deleteId);

    public void updateEntity(ArrayList<Resume> entityList,String updateId);

    public ArrayList<Resume> getEntityListByKey(ArrayList<Resume> entityList,int cond);

    public void close();

}
