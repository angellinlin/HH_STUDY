/*
* �������ݣ����ҽ�������Ľ�����б���
*
* */

package DataService;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

import Model.Book;

public class DataOperate {

    /*******************************�ڸտ�ʼʱ��Ҫ��Ӳ���е�����ȫ����ȡ������ֱ�����˳�ͼ�����ϵͳʱ�����������ݽ������¸���***********/
    public static void LoadData(LinkedList<Book> BookList){
        File f = new File("E:/Library_System/LibSystem_1/booklist.txt");
        try(FileReader fr = new FileReader(f);BufferedReader br = new BufferedReader(fr);){
            String str = br.readLine();
            if(str == null){
                System.out.println("ͼ��ϵͳ��û���鼮���밴1���������鼮������");
            }
            else{
                while(str != null){
                    String[] arr = str.split(",");
                    String name = arr[0];
                    String author = arr[1];
                    float price = Float.parseFloat(arr[2]);//��String����ת��Ϊfloat����
                    Book book = new Book(name,author,price);
                    BookList.add(book);

                    str = br.readLine();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

/****************************�˳�ͼ�����ϵͳʱ�洢ϵ�в�����Ľ��************************************8*/
    public static void SaveData(LinkedList<Book> Booklist){
        File f = new File("E:/Library_System/LibSystem_1/booklist.txt");
        Book book = null;

        try(
                //�����ļ��ַ���
                FileWriter fw = new FileWriter(f);
                //���������뽨����һ�����ڵ����Ļ�����
                PrintWriter pw = new PrintWriter(fw);
                ){
            for(Iterator<Book> iter = Booklist.iterator();iter.hasNext();){
                book = iter.next();
                pw.println(book.Bookname+","+book.BookAuthor+","+book.BookPrice);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
