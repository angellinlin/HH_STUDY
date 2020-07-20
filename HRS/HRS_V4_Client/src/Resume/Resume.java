package Resume;

public class Resume {
    //学生信息
    private String name;
    private String id;
    private String school;
    private String email;
//    private int process;//招聘进程
//    private int deleteStatus;//删除

    public Resume(String name, String school, String id, String email) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public String getEmail() {
        return email;
    }


}
