package com.spdb.resume.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resume")
public class Resume {
    @NotNull
    //姓名
    private String name;
    @NotNull
    @Id
    //身份证号
    private String id;
    @NotNull
    //学校
    private String school;
    /**
     * 简历状态
     * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：面试通过
     * 4：体检通过
     * 5：背调通过
     * 6：已签约
     * 7：已入职
     */
    @NotNull
    private int status;

    /**
     * 逻辑删除
     * 0：不展示
     * 1：展示
     */
    @NotNull
    private int deletestatus;

    public Resume() {
        super();
    }

    public Resume(String name, String id, String school, int status , int deleteStatus) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.status = status;
        this.deletestatus = deleteStatus;
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

    public int getStatus() {
        return status;
    }

    public int getDeleteStatus() {
        return deletestatus;
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

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deletestatus = deleteStatus;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", school='" + school + '\'' +
                ", status=" + status +
                ", deleteStatus=" + deletestatus +
                '}';
    }
}
