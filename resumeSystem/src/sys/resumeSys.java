package sys;
import java.util.ArrayList;
import java.util.Scanner;
import bean.Book;
import bean.Resume;
import java.io.*;
import operation.resumesOperation;
import database.jdbcTool;

public class resumeSys {
//	private static ArrayList<Resume> resumeArrayList=new ArrayList<>();
	private static int resumeCount = 0;
	//获取标准输入流
	private Scanner input=new Scanner(System.in);

	resumeSys() {
		resumesOperation op = new resumesOperation();
		resumeCount=op.getRow();

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
			resumesOperation op = new resumesOperation();
			int result = op.addResume(resume);
			if(result==1) {
				resumeCount++;
				System.out.println("您已经成功添加简历信息");
				showResume();
			}
			else{
				System.out.println("添加简历信息失败");
			}
		}

		//删除简历
		void deleteResume ()
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("欢迎进入删除信息界面");
			System.out.println("请输入需要删除的简历id");
			String resumeId = input.nextLine();
			if (resumeCount != 0)
			{
				resumesOperation op = new resumesOperation();
				int result = op.deleteResume(resumeId);
				if(result==0){
					System.out.println("没有找到该简历，删除失败");
				}
				else{
					System.out.println("该简历已被成功删除");
					resumeCount--;
				}
				op.showResume();
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
			if (resumeCount != 0)
			{
				System.out.println("简历信息管理系统共有" + resumeCount + "人"+",请选择对应简历进行修改");
				resumesOperation op = new resumesOperation();
				op.showResume();
				System.out.println("请依次输入简历ID及新的人名，性别，毕业学校，应聘进程");
				String resumeId = input.nextLine();
				String newName = input.nextLine();
				String newGender = input.nextLine();
				String newSchool = input.nextLine();
				String newProcess = input.nextLine();
				Resume resume = new Resume(newName, newGender, resumeId, newSchool, newProcess);
				int result = op.updateResume(resume);
				if(result==0){
					System.out.println("未找到id对应简历");
				}
				else{
					System.out.println("简历信息修改成功");
				}
			} else {
				System.out.println("系统为空，没有查找到已有简历，请进行简历信息添加");
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
			if(resumeCount == 0){
				System.out.println("系统为空，请重新录入简历信息");
				return;
			}
			else{
				resumesOperation op = new resumesOperation();
				ArrayList<Resume> resumeSet = op.searchResume(resumeId);
				if(resumeSet.size()==0){
					System.out.println("简历ID输入错误，请重新录入");
				}
				else{
					for(Resume r:resumeSet){
						System.out.println("姓名："+r.getName()+'\n'
						+"ID："+r.getId()+'\n'
						+"性别："+r.getGender()+'\n'
						+"学校："+r.getSchool()+'\n'
						+"应聘进程："+r.getProcess());
						System.out.println();
					}
					System.out.println("查询结束");
				}
			}

//		input.close();
		}

		//精简展示简历信息
		void showResume ()
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("是否需要打印所有信息，是请输入Y，不用打印则输入任意");
			String choice = input.nextLine();
			if (choice.equals("Y")||choice.equals("y")) {
				System.out.println("简历信息管理系统共有" + resumeCount + "人");
//				for (int i = 0; i < resumeCount; i++) {
//					System.out.println((i + 1) + "\t" + "姓名：" + resumeArrayList.get(i).getName() +"\t"+"简历id："+
//							resumeArrayList.get(i).getId());
//				}
				resumesOperation op = new resumesOperation();
				ArrayList<Resume> resumeSet = op.showResume();
				int index = 0;
				for(Resume r:resumeSet){
					System.out.println(index+"\t"+"姓名：" + r.getName() +"\t"+"简历id："+
							r.getId());
					index++;
				}
			}
//		input.close();
		}
		/**
		* 从文件中读取数据
		*/
//		public static void readFile() throws IOException{
//			BufferedInputStream FileInput = new BufferedInputStream(new FileInputStream("ResumesFile.txt"));
//			String fileData = "";
//			byte[] nums = new byte[512];
//			int len;
//			while((len = FileInput.read(nums)) != -1){
//				fileData = fileData+new String(nums,0,len);
//			}
//			FileInput.close();
//			if(fileData.equals("")) return;
//			String[] fileDatas = fileData.split("\n");
//			String[] splitDatas= new String[5];
//			ArrayList<String[]> resumesList= new ArrayList<String[]>();
//			for(String s:fileDatas){
//				splitDatas = s.split(",");
//				resumesList.add(splitDatas);
//			}
//			for(String[] singleResume:resumesList){
//				resumeArrayList.add(new Resume(singleResume[0],singleResume[1],singleResume[2],singleResume[3],singleResume[4]));
//			}
//		}
//		public static void writeFile() throws IOException{
//			BufferedOutputStream fileOutput = new BufferedOutputStream(new FileOutputStream("ResumesFile.txt"));
//			String allResumes= "";
//			for(Resume r:resumeArrayList){
//				allResumes = allResumes+r.formatToFile();
//			}
//			fileOutput.write(allResumes.getBytes());
//			fileOutput.close();
//		}
	public static void main(String[] args)
	{
		new resumeSys();
	}
}