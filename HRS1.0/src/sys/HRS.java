package sys;

import bean.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {
    //获取标准输入流，为了关闭流
    private Scanner input = new Scanner(System.in);
    private ArrayList<Resume> resumeArrayList = new ArrayList<>();

    public static void main(String[] args) {
        new HRS();
    }

    HRS() {
        loop:
        while (true) {
            System.out.println("---欢迎进入HR系统---");
            System.out.println("---增加简历请按1---");
            System.out.println("---查询简历请按2---");
            System.out.println("---修改简历请按3---");
            System.out.println("---删除简历请按4---");
            System.out.println("---打印简历请按5---");
            System.out.println("---退出系统请按6---");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addResume(resumeArrayList);
                    break;
                case 2:
                    queryResume(resumeArrayList);
                    break;
                case 3:
                    updateResume(resumeArrayList);
                    break;
                case 4:
                    deleteResume(resumeArrayList);
                    break;
                case 5:
                    showResume(resumeArrayList);
                    break;
                case 6:
                    System.out.println("退出系统");
                    break loop;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
        input.close();
    }

    private void deleteResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请输入要删除的简历id");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        if (resumeArrayList.size() != 0) {
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if (resumeArrayList.get(i).getId().equals(id)) {
                    resumeArrayList.get(i).setDeleteStatus(0);
                    System.out.println("删除简历成功");
                    break;
                } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                    System.out.println("未找到对应简历");
                }
            }
        } else {
            System.out.println("系统中还未录入简历");
        }
    }

    void showResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("是否打印简历，是选择y");
        Scanner input = new Scanner(System.in);
        String choose = input.nextLine();
        String y = "y";
        if (choose.equals(y)) {
            if (resumeArrayList.size() != 0) {
                for (int i = 0; i < resumeArrayList.size(); i++) {
                    if (resumeArrayList.get(i).getDeleteStatus() == 1) {
                        System.out.println(resumeArrayList.get(i));
                    }
                }
            } else {
                System.out.println("系统中还未录入简历");
            }
        }
    }

    void addResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请添加简历");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        int status = input.nextInt();

        Resume newResume = new Resume(name, id, school, status);
        newResume.setName(name);
        newResume.setId(id);
        newResume.setSchool(school);
        newResume.setStatus(status);
        newResume.setDeleteStatus(1);
        resumeArrayList.add(newResume);
        showResume(resumeArrayList);
    }


    void queryResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请输入id查询简历");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        if (resumeArrayList != null) {
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if (resumeArrayList.get(i).getId().equals(id)) {
                    if (resumeArrayList.get(i).getDeleteStatus() == 1) {
                        System.out.println(resumeArrayList.get(i).getName());
                        break;
                    } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                        System.out.println("未找到对应简历");
                    }
                } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                    System.out.println("未找到对应简历");
                }
            }
        } else {
            System.out.println("系统中还未录入简历");
        }
    }

    void updateResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请输入要修改的简历id");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        if (resumeArrayList.size() != 0) {
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if (resumeArrayList.get(i).getId().equals(id) && resumeArrayList.get(i).getDeleteStatus() == 1) {
                    System.out.println("请输入新的简历信息");
                    String newName = input.nextLine();
                    String newId = input.nextLine();
                    String newSchool = input.nextLine();
                    int newStatus = input.nextInt();
                    Resume newResume = new Resume(newName, newId, newSchool, newStatus);
                    resumeArrayList.set(i, newResume);
                    showResume(resumeArrayList);
                } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                    System.out.println("未找到对应简历");
                }
            }
        } else {
            System.out.println("系统中还未录入简历");
        }
    }
}
