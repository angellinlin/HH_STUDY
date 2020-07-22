package util;

import model.Resume;

public class Protocol {
	public Protocol()
	{

	}
	public String AddBookMessage(Resume resume)
	{
		String str="add/n"+resume.getName()+","+resume.getId()+","+resume.getSchool();
		return str;
	}
	public String deleteBookByNameMessage(Resume resume)
	{
		String str="deletebyname/n"+resume.getName();
		return str;
	}
	public String changeBookMessage(Resume resume, Resume oldResume)
	{
		String str="change/n"+resume.getName()+","+resume.getId()+","+resume.getSchool()+";"+oldResume.getName()+","+oldResume.getId()+","+oldResume.getSchool();
		return str;
	}
	public String searchBookByNameMessage(Resume resume)
	{
		String str="searchbyname/n"+resume.getName();
		return str;
	}
	public String searchBookByIdMessage(Resume resume)
	{
		String str="searchbyid/n"+resume.getId();
		return str;
	}
	public String searchBookBySchoolMessage(Resume resume)
	{
		String str="searchbyschool/n"+resume.getSchool();
		return str;
	}
	public String searchBookByKeyWordMessage(Resume resume)
	{
		String str="searchbykeyword/n"+resume.getName();
		return str;
	}
	public String closenetMessage(String string)
	{
		String str=string+"/n";
		return str;
	}
}

