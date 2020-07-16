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
            /*同一对象的字段按','分割；不同对象按';'分割*/
            res+=r.getName()+","+r.getId()+","+r.getSchool()+","+r.getProcess()+";";
        }
        mr.str_entity=res;
        return mr;
    }
}
