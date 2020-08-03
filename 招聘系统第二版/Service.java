package bean;

import java.util.LinkedList;
import java.util.Scanner;

/*
提供增删查改遍历等操作
修改第一版系统中的bug
*/
public class Service {

    //都是静态方法，可以直接通过类名称进行调用
    //增加个人简历
    public static void addResumeInfo(LinkedList<Resume> linkedList) {
        System.out.println("[欢迎进入添加个人简历界面]");
        //创造输入流
        Scanner resumeInfor = new Scanner(System.in);
        // System.out.println("请分别输入姓名，年龄，学校，性别信息，每次以回车结束");
        //Resume newResume = new Resume(resumeInfor.next(), resumeInfor.next(), resumeInfor.nextInt(), resumeInfor.next());
        System.out.println("请输入姓名：");
        String name = resumeInfor.next();
        System.out.println("请输入学校：");
        String school = resumeInfor.next();
        System.out.println("请输入年龄：");
        int age = resumeInfor.nextInt();
        System.out.println("请输入性别：");
        String sex = resumeInfor.next();
        Resume newResume = new Resume(name, age, school, sex);
        linkedList.add(newResume);
        System.out.println("您已成功添加个人简历，简历信息为 姓名：" + newResume.getResumeName() + "  年龄：" + newResume.getResumeAge()
                + "  学校：" + newResume.getResumeSchool() + "  性别：" + newResume.getSex());
        //        showResumeInfo(arrayList);//显示简历信息
    }

    //删除个人简历
    public static void delResumeInfo(LinkedList<Resume> linkedList) {
        System.out.println("[欢迎进入删除个人简历界面]");
        //创造输入流
        Scanner resumeInfor = new Scanner(System.in);
        System.out.println("请输入需要删除的姓名");
        String name = resumeInfor.nextLine();
        int resumeCount = linkedList.size();
        for (int i = 0; i < linkedList.size(); i++) {
            //有这个人并且逻辑上还没有被删除
            if ((linkedList.get(i).getResumeName().equals(name))) {//equals用于比较字符串内容是否相等，==用于比较地址
                //linkedList.get(i).setId(0);//实现逻辑删除，显示的时候不显示
                linkedList.remove(i);//物理删除
                System.out.println("您已成功删除该简历信息");
                break;//一旦删除即退出，不需要进行后续遍历。如果有重名怎么办？增加判断标准或者使用身份证号
            } else if (i == resumeCount - 1 || resumeCount == 0) {
                System.out.println("对不起，没有找到该简历");
            }
        }
        //        showResumeInfo(arrayList);//显示简历信息
    }

    //修改个人简历
    public static void updateResumeInfo(LinkedList<Resume> linkedList) {
        System.out.println("[欢迎进入修改个人简历界面]");
        //创造输入流
        Scanner resumeInfor = new Scanner(System.in);
        System.out.println("请输入需要修改的简历姓名");
        String name = resumeInfor.next();
        int resumeCount = linkedList.size();
        for (int i = 0; i < resumeCount; i++) {
            //若查找到名字相符的数据并且没有被逻辑删除
            if ((linkedList.get(i).getResumeName().equals(name))) {
                System.out.println("请输入姓名：");
                String newname = resumeInfor.next();
                System.out.println("请输入年龄：");
                int age = resumeInfor.nextInt();
                System.out.println("请输入学校：");
                String school = resumeInfor.next();
                System.out.println("请输入性别：");
                String sex = resumeInfor.next();
                Resume newResume = new Resume(newname, age, school, sex);
                linkedList.set(i, newResume);
                System.out.println("您已成功修改个人简历");
                break;
            } else if (i == resumeCount - 1 || resumeCount == 0) {
                System.out.println("对不起，没有找到符合条件的简历");
            }
        }
        //        showResumeInfo(arrayList);//显示简历信息
    }

    //查找个人简历
    public static void researchResumeInfo(LinkedList<Resume> linkedList) {
        System.out.println("[欢迎进入查找个人简历界面]");
        //创造输入流
        Scanner resumeInfor = new Scanner(System.in);
        System.out.println("请输入需要查找的简历姓名：");
        String name = resumeInfor.next();
        int resumeCount = linkedList.size();
        for (int i = 0; i < resumeCount; i++) {
            if ((linkedList.get(i).getResumeName().equals(name))) {
                System.out.println("您查找的个人简历信息为 姓名：" + linkedList.get(i).getResumeName() + "  年龄：" + linkedList.get(i).getResumeAge()
                        + "  学校：" + linkedList.get(i).getResumeSchool() + "  性别：" + linkedList.get(i).getSex());
                break;
            } else if (i == resumeCount - 1 || resumeCount == 0) {
                System.out.println("对不起，没有找到符合条件的简历");
            }
        }
        //        showResumeInfo(arrayList);//显示简历信息
    }

    //遍历简历信息
    public static void showResumeInfo(LinkedList<Resume> linkedList) {
        System.out.println("[是否需要打印所有简历，是请输入Y]");
        //创造输入流
        Scanner resumeInfor = new Scanner(System.in);
        if (resumeInfor.next().equals("Y")) {
            System.out.println("本简历系统的简历信息如下：");
            for (int i = 0; i < linkedList.size(); i++) {
//                //只有当id=1的时候才显示，否则不显示
//                if ((linkedList.get(i).getId() == 1)) {
//                    System.out.println("  姓名：" + linkedList.get(i).getResumeName() + "  年龄：" + linkedList.get(i).getResumeAge()
//                            + "  学校：" + linkedList.get(i).getResumeSchool() + "  性别：" + linkedList.get(i).getSex());
//                }
                System.out.println("  姓名：" + linkedList.get(i).getResumeName() + "  年龄：" + linkedList.get(i).getResumeAge()
                        + "  学校：" + linkedList.get(i).getResumeSchool() + "  性别：" + linkedList.get(i).getSex());
            }
        }
    }
}
