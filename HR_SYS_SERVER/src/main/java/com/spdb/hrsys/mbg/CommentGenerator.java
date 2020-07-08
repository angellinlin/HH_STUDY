package com.spdb.hrsys.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

public class  CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;
    private static final String EMPTY_SUFFIX = "Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";

    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * 给字段加注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)){
            if (remarks.contains("\""))
                remarks.replace("\"", "'");
            field.addJavaDocLine("@ApiModelProperty(value=\"" + remarks + "\")");
        }
    }

    /**
     * 给model添加注释
     */
    private void addModelJavaDoc(Field field, String remarks){
        field.addJavaDocLine("/**");
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine: remarkLines){
            field.addJavaDocLine("*"+ remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine("*/");
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        if (!compilationUnit.getType().getFullyQualifiedName().contains(EMPTY_SUFFIX))
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
    }
}
