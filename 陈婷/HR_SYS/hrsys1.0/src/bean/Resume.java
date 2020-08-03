package bean;

public class Resume {
    // 姓名
    private String name;
    // 身份证号
    private String id;
    // 学校
    private String school;

    /* 流程
      0：已申请
      1：简历通过
      2：笔试通过
      3：体检通过
      4：背调通过
      5：已签约
      6：已入职
      */
    private int process;
    /*
    * 删除逻辑
    * 0：不展示
    * 1：展示
    * */
    private int deleteStatus;

    // 无参构造方法
    public Resume() {
    }

    // 有参构造方法
    public Resume(String name, String id, String school) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = 0;
        this.deleteStatus = 1;
    }

    // Getter and Setter
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
}
