package ioservice;

import bean.Resume;
import java.util.ArrayList;
public interface IOService {
     void save(ArrayList<Resume> entityList);
     void load(ArrayList<Resume>  entityList);
}
