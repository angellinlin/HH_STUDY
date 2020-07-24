/*
* ͼ�������������
*
* */

package BookService;

import java.util.LinkedList;
import java.util.Scanner;

import Model.Book;
public class BookService {
    //1������ͼ��
    public static void addbook(LinkedList<Book>booklist){
        System.out.println("*****************��ӭ����ͼ����Ӳ�������******************");
        System.out.println("�����������ͼ���������");
        Scanner Input_list = new Scanner(System.in);
        String BookName= Input_list.nextLine();

        System.out.println("�����������ͼ������ߣ�");
        String BookAuthor= Input_list.nextLine();

        System.out.println("�����������ͼ��ļ۸�");
        Float BookPrice= Input_list.nextFloat();

        Book book = new Book(BookName,BookAuthor,BookPrice);
        booklist.add(book);
        System.out.println("-----------------���ѳɹ����ͼ�飡--------------------------");
        BookService.showbook(booklist);

    }

    //2��ɾ��ͼ��
    public static void deletebook(LinkedList<Book> booklist){
        System.out.println("*****************��ӭ����ͼ��ɾ����������******************");
        System.out.println("��������Ҫɾ����ͼ�����֣�");
        Scanner Input_list = new Scanner(System.in);
        String BookName = Input_list.nextLine();

        int index=0;
        for(Book book:booklist){//����
            if(book.Bookname.equals(BookName)){
                booklist.remove(index);
                System.out.println("-----------------����ɾ���ɹ���-------------------");
                break;
            }
            else if(index == booklist.size()-1){
                System.out.println("-----------------ϵͳ��û�и�ͼ�飡----------------");
                break;
            }
            index++;
        }
        BookService.showbook(booklist);
    }

    //3������ͼ����Ϣ
    public static void updatebook(LinkedList<Book> booklist){
        System.out.println("***************��ӭ����ͼ����Ϣ���Ľ���***************");
        System.out.println("��������Ҫ��Ϣ���ĵ�ͼ������");
        Scanner Input = new Scanner(System.in);
        String updatename = Input.nextLine();
        for(int index = 0;index<booklist.size();index++){//����
            if(booklist.get(index).Bookname.equals(updatename)){//�ж��������һ��
                System.out.println("�������µ�ͼ������");
                String name = Input.nextLine();
                System.out.println("�������µ���������");
                String author = Input.nextLine();
                System.out.println("���������ļ۸�");
                float price = Float.parseFloat(Input.nextLine());
                Book book = new Book(name,author,price);
                booklist.set(index,book);
            }
            else if(index == booklist.size()-1){
                System.out.println("------------ϵͳ��û�и��鼮������ϸ��������Ƿ�������ȷ��---------");
            }
        }
        BookService.showbook(booklist);
    }

    //��ѯͼ����Ϣ
    public static void searchbook(LinkedList<Book> booklist){
        System.out.println("*****************��ӭ����ͼ���ѯ����******************");
        System.out.println("�Ƿ��ѯ����ͼ����Ϣ�������������Y(��y),��������������");
        Scanner Input = new Scanner(System.in);
        String single = Input.nextLine();
        if(single.equals("Y") || single.equals("y")){
            System.out.println("��������Ҫ��ѯ��ͼ������");
            String name = Input.nextLine();
            int index=0;
            for(Book book:booklist){//����ϵͳ�е��鼮
                if(book.Bookname.equals(name)){
                    System.out.println("ͼ������ "+book.Bookname+"      "+"���ߣ�"+book.BookAuthor+"      "+"��ļ۸�"+book.BookPrice);
                }
                else if(index == booklist.size()){
                    System.out.println("------------ϵͳ��û�и��鼮������ϸ��������Ƿ�������ȷ��---------");
                }
                index++;
            }
        }
        BookService.showbook(booklist);
    }

    //�Ƿ�չʾ�������ͼ����Ϣ
    public static void showbook(LinkedList<Book> booklist){
        System.out.println("�Ƿ���Ҫ��ӡ����ͼ����Ϣ�������Ҫ��ӡ������Y(����y);�����������ֵ�˳���");
        Scanner Input = new Scanner(System.in);
        String IFP = Input.nextLine();
        if(IFP.equals("Y") || IFP.equals("y") ){
            if(booklist.size()>0){
                for(Book book:booklist){
                    System.out.println(book.Bookname+"��"+book.BookAuthor+","+book.BookPrice);
                }
            }
            else{
                System.out.println("--------------ϵͳ��û���鼮�������ͼ����Ӳ�����----------------");
            }

        }
    }
}
