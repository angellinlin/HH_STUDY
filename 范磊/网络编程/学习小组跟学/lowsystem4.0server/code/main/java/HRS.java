import JDBC.MySQLConnect;
import bean.PersistenceStorageInMySql;

import java.util.Scanner;

public class HRS {

    PersistenceStorageInMySql operate = new PersistenceStorageInMySql();

    private Scanner input = new Scanner(System.in);

    HRS() {

        while(true){
            base:
            try {
                System.out.println("-------欢迎进入人力资源管理系统------");
                System.out.println("人员添加请按----------1");
                System.out.println("人员删除请按----------2");
                System.out.println("人员修改请按----------3");
                System.out.println("人员查询请按----------4");
                System.out.println("退出系统请按----------5");

                int chioce = input.nextInt();

                switch (chioce) {
                    case 1:
                        operate.add();
                        break;
                    case 2:
                        operate.delete();
                        break;
                    case 3:
                        operate.change();
                        break;
                    case 4:
                        operate.search();
                        break;
                    case 5:
                        input.close();
                        System.out.println("退出人力资源管理系统");
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("输入错误,请重新输入");
                new HRS();
                e.printStackTrace();


                // 跳出存在问题
            }

        }
    }

    public static void main(String args[]){
        MySQLConnect mySQLConnect = new MySQLConnect();

        new HRS();

    }
}

