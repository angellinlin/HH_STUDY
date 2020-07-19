package cn.com.spdb.testidea08;

import java.util.Scanner;

public class Tset {

        public static void main(String[] args) {
            Scanner s=new Scanner(System.in);
            System.out.println("请输入字符串：");
            String a=s.nextLine();
            char b[]=a.toCharArray();
            System.out.println("其中的大写字母和数字有：");
            for(int i=0;i<b.length;i++){
                if(Character.isUpperCase(b[i])||Character.isDigit(b[i])){
                    System.out.print(b[i]+" ");
                }
            }
        }
    }
