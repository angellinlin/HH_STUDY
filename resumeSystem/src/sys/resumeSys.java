package sys;
import java.util.ArrayList;
import java.util.Scanner;
import bean.Book;
import bean.Resume;
import java.io.*;

public class resumeSys {
	private static ArrayList<Resume> resumeArrayList=new ArrayList<>();
	private static int resumeCount = 0;
	//获取标准输入流
	private Scanner input=new Scanner(System.in);

	resumeSys() {
		resumeCount=resumeArrayList.size();
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
		try {
			writeFile();
		} catch (IOException e) {
			e.printStackTrace();
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
			if (resumeCount != 0)
			{
				System.out.println("简历信息管理系统共有" + resumeCount + "人"+",请选择对应简历进行修改");
				for (int i = 0; i < resumeCount; i++) {
					System.out.println((i + 1) + "\t" + "姓名：" + resumeArrayList.get(i).getName() +"\t"+"简历id："+
							resumeArrayList.get(i).getId());
				}
				System.out.println("请输入需要修改的简历id");
				String resumeId = input.nextLine();
				for (int i = 0; i < resumeCount; i++) {
					if (resumeArrayList.get(i).getId().equals(resumeId)) {
						System.out.println("请依次输入新的人名，简历id，性别，毕业学校，应聘进程");
						String newName = input.nextLine();
						String newId = input.nextLine();
						String newGender = input.nextLine();
						String newSchool = input.nextLine();
						String newProcess = input.nextLine();
						Resume resume = new Resume(newName, newGender, newId, newSchool, newProcess);
						resumeArrayList.set(i, resume);
						System.out.println("您已经修改成功");
						showResume();
						break;
					} else if (i == resumeCount - 1 ) {
						System.out.println("没有查找到该简历");
					}
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
			if(resumeCount == 0){
				System.out.println("没有查找到该简历，请重新录入");
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
		/**
		* 从文件中读取数据
		*/
		public static void readFile() throws IOException{
			BufferedInputStream FileInput = new BufferedInputStream(new FileInputStream("ResumesFile.txt"));
			String fileData = "";
			byte[] nums = new byte[512];
			int len;
			while((len = FileInput.read(nums)) != -1){
				fileData = fileData+new String(nums,0,len);
			}
			FileInput.close();
			if(fileData.equals("")) return;
			String[] fileDatas = fileData.split("\n");
			String[] splitDatas= new String[5];
			ArrayList<String[]> resumesList= new ArrayList<String[]>();
			for(String s:fileDatas){
				splitDatas = s.split(",");
				resumesList.add(splitDatas);
			}
			for(String[] singleResume:resumesList){
				resumeArrayList.add(new Resume(singleResume[0],singleResume[1],singleResume[2],singleResume[3],singleResume[4]));
			}
		}
		public static void writeFile() throws IOException{
			BufferedOutputStream fileOutput = new BufferedOutputStream(new FileOutputStream("ResumesFile.txt"));
			String allResumes= "";
			for(Resume r:resumeArrayList){
				allResumes = allResumes+r.formatToFile();
			}
			fileOutput.write(allResumes.getBytes());
			fileOutput.close();
		}
	public static void main(String[] args)
	{
		try{
			readFile();
		}catch (FileNotFoundException fnfe){
			System.out.println("无简历信息文件");
			File resumesFileTxt = new File("ResumesFile.txt");
			try {
				resumesFileTxt.createNewFile();
				System.out.println("已创建新的简历信息文件");
			}catch (IOException ioe){
				System.out.println("文件创建失败，请手动在当前目录下创建ResumesFile.txt");
				ioe.printStackTrace();
			}
			fnfe.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		new resumeSys();

		try {
			writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}