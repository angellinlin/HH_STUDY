package util;

import model.MessageResult;
import model.Resume;

import java.util.ArrayList;
/*ResumeList -> String*/
public class ResumeProtocol {
    public MessageResult encode(ArrayList<Resume> list){
        MessageResult mr=new MessageResult();
        String res="";
        for(Resume r:list){
            res+=r.getName()+","+r.getId()+","+r.getSchool()+","+r.getProcess()+";";
        }
        mr.str_entity=res;
        return mr;
    }
}
