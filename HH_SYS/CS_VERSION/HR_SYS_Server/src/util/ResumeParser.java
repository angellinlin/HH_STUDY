package util;

import model.MessageResult;
import model.Resume;

import java.util.ArrayList;
/*String -> ResumeList*/
public class ResumeParser {
    public MessageResult parse(String str) {
        MessageResult mr = new MessageResult();
        if(str.charAt(str.length()-1)!=';'){
            System.out.println(str);
            return mr;
        }

        mr.type = "Entity";
        String[] ResumeList = str.split(";");
        mr.entityList=new ArrayList<Resume>();
        for (String strResume : ResumeList) {
            if (strResume.equals(""))
                continue;
            String[] properties = strResume.split(",");
            mr.entityList.add(new Resume(properties[1], properties[0], properties[2], Integer.parseInt(properties[3])));
        }
        return mr;
    }
}
