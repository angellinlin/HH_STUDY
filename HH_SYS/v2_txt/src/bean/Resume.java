package bean;
/**
 * @program: HR_SYS
 * @description: Resume Bean
 * @author: 朱戈
 * @create: 2020-07-03 09:10
 * @Update：2020-07-06
 * 1、添加toString()
 **/
public class Resume extends Entity{
    /**
     *姓名
     */
    private String name;
    /**
     *身份证号
     */
    private String id;
    /**
     *学校
     */
    private String school;
    /**
     *
     * * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     */
    private int process;
    /**
     *逻辑删除
     * 0 : 不展示
     * 1  展示
     */
    private int deleteStatus;

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

    public Resume(String name, String id,String school,int process) {
        this.name = name;
        this.id = id;
        this.school=school;
        this.process=process;
        this.deleteStatus=0;
    }

    @Override
    public String toString() {
        return  name+","+id+","+school+","+process+"\n";
    }
    public String printInfo() { /*控制台输出格式*/
        return  "简历姓名：" + getName() + "\n"
                + "身份证号：" + getId() + "\n"
                + "学校：" + getSchool() + "\n"
                + "简历状态：" + getProcess() + "\n";
    }

}
