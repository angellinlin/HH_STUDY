package Resume;

public class Resume {
    //学生信息
    private String name;
    private String id;
    private String school;
    private String email;
    private int process;//招聘进程
    private int deleteStatus;//删除

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Resume(String name, String id, String school, String email) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.email = email;
        this.process = 0;
        this.deleteStatus = 0;
    }
}
