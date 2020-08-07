package com.spdb.study.hrs.hr1.dataobject;

import java.io.Serializable;

/**
 * 考核类型实体
 * @author Mr.Longyx
 * @date 2020年07月20日 21:54
 */
public class ExamineType implements Serializable {
    private static final long serialVersionUID = 2576945392674554990L;

    private int examineTypeId;
    private String examineTypeName;

    public void setExamineTypeId(int examineTypeId) {
        this.examineTypeId = examineTypeId;
    }

    public void setExamineTypeName(String examineTypeName) {
        this.examineTypeName = examineTypeName;
    }

    public int getExamineTypeId() {
        return examineTypeId;
    }

    public String getExamineTypeName() {
        return examineTypeName;
    }
}