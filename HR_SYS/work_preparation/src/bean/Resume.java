package bean;

//resume
public class Resume {
    /*
    * 名字
    * 身份证号
    * 学校
    * */
    private String name;
    private String id;
    private String school;
    /*
    * 应聘流程
    * 0 投递简历
    * 1 简历通过
    * 2 笔试通过
    * 3 体检通过
    * 4 背调通过
    * 5 已签约
    * 6 已入职
    */
    private int process;
    /*
    * 逻辑删除
    * 0 不展示
    * 1 展示
    * */
    private int deleteStatus;
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public int getProcess() {
        return process;
    }

    public int getDeleteStatus() {
        return deleteStatus;
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

    public void setProcess(int process) {
        this.process = process;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Resume(String name, String id, String school) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = 0;
        this.deleteStatus = 0;
    }

    public Resume(String name, String id, String school, int process, int deleteStatus) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = process;
        this.deleteStatus = deleteStatus;
    }
}
