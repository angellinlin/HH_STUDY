package service;

import model.Resume;

import java.util.ArrayList;

public interface DBCRUDService {
    public boolean addEntity(Resume resume);

    public boolean deleteEntity(String deleteId);

    public boolean updateEntity(Resume resume);

    public ArrayList<Resume> getEntityListByKey(int cond,String key);

    public void close();
}
