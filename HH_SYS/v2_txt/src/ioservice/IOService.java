package ioservice;

import bean.Resume;
import pojo.EntityList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IOService {
     void save(ArrayList<Resume> entityList) throws IOException;
     void load(ArrayList<Resume>  entityList) throws IOException, ClassNotFoundException;
}
