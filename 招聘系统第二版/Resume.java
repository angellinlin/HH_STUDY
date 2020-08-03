package bean;

/*
个人信息属性：
姓名：resumeName
年龄：resumeAge
学校：resumeSchool
性别：sex
逻辑删除控制：id
*/
public class Resume {
    //用private修饰,提供外部获取方法
    private String resumeName;
    private int resumeAge;
    private String resumeSchool;
    private String sex;
    //private int id = 1;//用来控制逻辑删除，创建者不需要指定，只有在删除的时候系统置为0

    public Resume(String resumeName, int resumeAge, String resumeSchool, String sex) {
        this.resumeName = resumeName;
        this.resumeAge = resumeAge;
        this.resumeSchool = resumeSchool;
        this.sex = sex;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public int getResumeAge() {
        return resumeAge;
    }

    public void setResumeAge(int resumeAge) {
        this.resumeAge = resumeAge;
    }

    public String getResumeSchool() {
        return resumeSchool;
    }

    public void setResumeSchool(String resumeSchool) {
        this.resumeSchool = resumeSchool;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
