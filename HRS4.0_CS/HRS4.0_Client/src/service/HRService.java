package service;

import control.Operator;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;

import java.util.Scanner;

public class HRService {

    private Operator operator = new Operator();

    //添加简历
    public void addResume() {
        System.out.println("欢迎来到简历添加界面");
        System.out.println("请依次输入学生名字，学生身份证号，学生学校, 简历状态");

        Scanner input = new Scanner(System.in);
        String name = input.next();
        String id = input.next();
        String school = input.next();
        String status = input.next();
        Resume resume = new Resume(name,id,school,status,"1"); //deleteStatus默认为1

        ReturnResult returnResult = operator.addResume(resume);

        if (returnResult.isSuccess){
            System.out.println("简历添加成功！");
        }else {
            System.out.println("简历添加失败，失败原因："+returnResult.failReason);
        }
    }

    //通过id删除简历
    public void deleteResume() {
        System.out.println("欢迎来到简历删除界面");
        System.out.println("请输入需要删除的简历的学生id");

        Scanner input = new Scanner(System.in);
        String id = input.next();

        Resume resume = new Resume(null,id,null,null,null);
        ReturnResult returnResult = operator.deleteResume(resume);

        if (returnResult.isSuccess){
            System.out.println("简历删除成功!");
        }else {
            System.out.println("简历删除失败! 失败原因：" + returnResult.failReason);
        }
    }

    //通过id修改简历
    public void updateResume(){
        System.out.println("欢迎来到简历信息修改界面");
        System.out.println("请输入需要修改的简历的学生id");

        Scanner input = new Scanner(System.in);
        String id = input.next();
        Resume oldResume = new Resume(null, id, null,null,null);

        System.out.println("请依次输入学生名字，身份证号，学校, 简历状态");
        String newName = input.next();
        String newId = input.next();
        String newSchool = input.next();
        String newStatus = input.next();
        Resume newResume = new Resume(newName,newId,newSchool,newStatus,"1");

        ReturnResult returnResult = operator.updateResume(oldResume,newResume);

        if (returnResult.isSuccess){
            System.out.println("简历修改成功!");
        }else {
            System.out.println("简历修改失败! 失败原因：" + returnResult.failReason);
        }
    }

    //通过id查找简历
    public void queryResume(){
        System.out.println("请输入需要显示简历信息的id");
        Scanner input = new Scanner(System.in);
        String id = input.next();
        Resume resume = new Resume(null, id, null,null,null);

        ReturnResult returnResult = operator.searchResume(resume);

        if (!returnResult.isSuccess) {
            System.out.println("查找简历失败！失败原因："+returnResult.failReason);
        }else {
            ResumeList resumeList = (ResumeList) returnResult.resultData;
            for (Resume r: resumeList
                 ) {
                System.out.println(r.getName()+"的身份证号为：" + r.getId() + "，学校为：" + r.getSchool() + ", 简历状态为："+ r.getStatus());
            }
        }
    }

    public void closeService(String str){
        operator.closeNet(str);
    }
}
