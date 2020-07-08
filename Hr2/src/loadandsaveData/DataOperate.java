package loadandsaveData;

import model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("all")
public class DataOperate
{
	public static void loadData(ArrayList<Resume> hrList)
	{
	BufferedReader br = null;
	try
		{
			br = new BufferedReader(new FileReader("D:\\file.txt"));
			String data = br.readLine();
			while(data!=null)
				{
					String[] str = data.split(",");
					String hrName =str[0];
					String hrId =str[1];
					String hrSchool =str[2];
					int hrProcess =Integer.parseInt(str[3]);
					int hrDeleteStatus =Integer.parseInt(str[4]);
					Resume student = new Resume(hrName,hrId,hrSchool,hrProcess,hrDeleteStatus);
					hrList.add(student);
				  	data = br.readLine();
				}
		}
	 catch(IOException exception)
		{
		 	exception.printStackTrace();
		}
	finally
		{
	  	try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}

	public static void saveData(ArrayList<Resume> hrList)
	{
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:\\file.txt",false)));//����д��
			int hrCount = hrList.size();
			for(int i=0;i<hrCount;i++)
			{
				printWriter.println(hrList.get(i).getName()+","+hrList.get(i).getId()+","+hrList.get(i).getSchool()+","+hrList.get(i).getProcess()+","+hrList.get(i).getDeleteStatus());
			}
			printWriter.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			printWriter.close();
		}
	}
}
