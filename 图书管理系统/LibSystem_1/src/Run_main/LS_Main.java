/*
* ��������
* */

package Run_main;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import BookService.BookService;
import DataService.DataOperate;
import Model.Book;
public class LS_Main {
    public static void main(String[] args){
        File f = new File("E:/Library_System/LibSystem_1/booklist");

        Scanner Input_id = new Scanner(System.in);

        LinkedList<Book> booklist = new LinkedList<Book>();//˫������
        DataOperate.LoadData(booklist);
        System.out.println("************��ӭ����ͼ�����ϵͳ��*************");
        outloop:
        while(true){

            System.out.println("����ͼ���밴����������������������������1");
            System.out.println("ɾ��ͼ���밴����������������������������2");
            System.out.println("�޸�ͼ���밴����������������������������3");
            System.out.println("��ѯͼ���밴����������������������������4");
            System.out.println("�˳�ͼ�����ϵͳ�밴��������������������5");

            int choice = Input_id.nextInt();
            switch(choice){
                case 1:
                    BookService.addbook(booklist);//����ͼ��
                    break;
                case 2:
                    BookService.deletebook(booklist);//ɾ��ͼ��
                    break;
                case 3:
                    BookService.updatebook(booklist);//����ͼ����Ϣ
                    break;
                case 4:
                    BookService.searchbook(booklist);//��ѯͼ����Ϣ
                    break;
                case 5:
                    DataOperate.SaveData(booklist);//�洢����������˳�
                    break outloop;
                    default:
                        System.out.println("���������ȷ�Ϻ��������룡");
            }
        }
        System.out.println("�����˳�ͼ�����ϵͳ��");
    }

}
