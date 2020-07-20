package util;

import Resume.Resume;

public class Protocol {
    //添加简历操作
    public String addResumeMessage(Resume resume) {
        String str = "add/n" + resume.getName() + "," + resume.getSchool() + ","
                + resume.getId() + "," + resume.getEmail();
        return str;
    }

    //删除简历操作
    public String deleteResumeMessage(Resume resume) {
        String str = "delete/n" + resume.getId();
        return str;
    }

    //修改简历信息操作
    public String modifyResumeMessage(Resume preResume, Resume resume) {
        String str = "modify/n" + preResume.getName() + "," + preResume.getSchool() + "," + preResume.getId() + ","
                + preResume.getEmail() + ";" + resume.getName() + "," + resume.getSchool() + "," + resume.getId()
                + "," + resume.getEmail();
//        String str = "modify/n" + preResume.getId() + ";" + resume.getName() + "," + resume.getSchool() + "," + resume.getId()
//                + "," + resume.getEmail();
        return str;
    }

    //查找简历
    public String searchResumeMessage(Resume resume) {
        String str="search/n"+resume.getId();
        return str;
    }
    //查找全部简历
    public String searchAllResumesMessage(){
        String str="searchAll/n";
        return str;
    }
}
