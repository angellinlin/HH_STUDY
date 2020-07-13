package sys;

import java.util.ArrayList;
import java.util.Scanner;
import bean.Book;
import bean.Resume;

public class resumeSys {
	ArrayList<Resume> resumeArrayList=new ArrayList<>();
	private static int resumeCount=0;
	//获取标准输入流
	private Scanner input=new Scanner(System.in);

	resumeSys() {

		while (true) {
			System.out.println("-----欢迎进入SPDB的应聘简历管理系统-----");
			System.out.println("添加应聘人员信息请按----1");
			System.out.println("删除应聘人员信息请按----2");
			System.out.println("修改应聘人员信息请按----3");
			System.out.println("查询应聘人员信息请按----4");
			System.out.println("退出请按--------5");

			int choice = input.nextInt();
			switch (choice) {
				case 1:
					addResume();
					break;
				case 2:
					deleteResume();
					break;
				case 3:
					updateResume();
					break;
				case 4:
					searchResume();
					break;
				case 5:
					break;
				default:
					System.out.println("输入错误，请重新输入:");
			}
			if(choice==5) break;
		}
		input.close();
		System.out.println("您已经退出简历管理系统");
	}

		//添加信息
		void addResume()
		{
			System.out.println("欢迎进入添加简历信息界面");

			Scanner input = new Scanner(System.in);
			System.out.println("请依次输入需要添加的人名，简历id");
			String resumeName = input.nextLine();
			String resumeId = input.nextLine();

			//get/SET
			Resume resume = new Resume(resumeName, resumeId);

			resumeArrayList.add(resume);
			resumeCount++;
			System.out.println("您已经成功添加简历信息");
			showResume();
		}

		//删除图书
		void deleteResume ()
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("欢迎进入删除信息界面");
			System.out.println("请输入需要删除的简历id");
			String resumeId = input.nextLine();
			if (resumeCount != 0)
			{
				for (int i = 0; i < resumeCount; i++) {
					if (resumeArrayList.get(i).getId().equals(resumeId)) {
						for (int j = i; j < resumeCount - 1; j++) {
							resumeArrayList.set(j, resumeArrayList.get(j + 1));
						}
						System.out.println("您已经成功删除该简历");
						resumeCount--;
						break;
					} else if (i == resumeCount - 1) {
						System.out.println("没有找到该简历");
					}
				}
				showResume();
			} else {
				System.out.println("简历管理系统为空，没有找到该简历");
			}
//		input.close();
		}

		//修改信息
		void updateResume ()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("欢迎进入修改信息界面");
			System.out.println("请输入需要修改的简历id");
			String resumeId = input.nextLine();
			if (resumeCount != 0)
			{
				for (int i = 0; i < resumeCount; i++) {
					if (resumeArrayList.get(i).getId().equals(resumeId)) {
						System.out.println("请依次输入新的人名，简历id，性别，毕业学校，应聘进程");
						String newName = input.nextLine();
						String newId = input.nextLine();
						String newGender = input.nextLine();
						String newSchool = input.nextLine();
						int newProcess = input.nextInt();
						Resume resume = new Resume(newName, newId, newGender, newSchool, newProcess);
						resumeArrayList.set(i, resume);
						System.out.println("您已经修改成功");
						showResume();
					} else if (i == resumeCount - 1 ) {
						System.out.println("没有查找到该简历");
					}
				}
			} else {
				System.out.println("系统为空，没有查找到该简历");
			}
//		input.close();
		}

		//查询信息
		void searchResume ()
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("欢迎进入查询简历信息界面");
			System.out.println("请输入需要查询的简历id");
			String resumeId = input.nextLine();
			for (int i = 0; i < resumeCount; i++) {
				if (resumeArrayList.get(i).getId().equals(resumeId)) {
					System.out.println("姓名：" + resumeArrayList.get(i).getName()  + "\n" +
							"id："  + resumeArrayList.get(i).getId() + "\n"
							+"性别：" +resumeArrayList.get(i).getGender() + "\n"
							+"毕业学校："+resumeArrayList.get(i).getSchool()+"\n"
									+ "应聘进程："  + resumeArrayList.get(i).getProcess() + "\n"
							);
					break;
				} else if (i == resumeCount - 1) {
					System.out.println("没有查找到该简历，请重新输入");
				}
			}
//		input.close();
		}

		//遍历
		void showResume ()
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("是否需要打印所有信息，是请输入Y，不用打印则输入任意");
			String choice = input.nextLine();
			if (choice.equals("Y")||choice.equals("y")) {
				System.out.println("简历信息管理系统共有" + resumeCount + "人");
				for (int i = 0; i < resumeCount; i++) {
					System.out.println((i + 1) + "\t" + "姓名：" + resumeArrayList.get(i).getName() +"\t"+"简历id："+
							resumeArrayList.get(i).getId());
				}
			}
//		input.close();
		}
	public static void main(String[] args)
	{
		new resumeSys();
	}
}