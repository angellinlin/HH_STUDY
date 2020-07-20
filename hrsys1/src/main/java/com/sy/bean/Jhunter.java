package com.sy.bean;
/**
 * @author sy
 * @date 2020/7/17 14:18
 */

/**
 * 求职者bean
 */
public class Jhunter {
    //序号
    private int id;

    //姓名
    private String name;

    //身份证id
    private String identity;

    //年龄
    private int age;

    //学校
    private String school;

    //专业
    private String specialty;

    /**
     * 流程状态
     *  0：已申请
     *  1：简历通过
     *  2：笔试通过
     *  3：体检通过
     *  4：背调通过
     *  5：已签约
     *  6：已入职
     */
    private int tag;

    public Jhunter() {
    }

    public Jhunter(int id, String name, String identity, int age, String school, String specialty, int tag) {
        this.id = id;
        this.name = name;
        this.identity = identity;
        this.age = age;
        this.school = school;
        this.specialty = specialty;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    @Override
    public String
    toString() {
        return "Jhunter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", specialty='" + specialty + '\'' +
                ", tag=" + tag +
                '}';
    }
}
