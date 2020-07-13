import bean.Employee;
import dao.EmployeeDao;

import java.util.Scanner;

/**
 * @Author LeiPeng
 * @Date 2020/7/13 - 12:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (true) {
            System.out.println("*****欢迎来到员工管理系统*****");
            System.out.println("添加员工请输入*****1");
            System.out.println("冻结员工请输入*****2");
            System.out.println("修改员工请输入*****3");
            System.out.println("查询员工请输入*****4");
            System.out.println("退出系统请输入*****5");
            int choice = sc.nextInt();
            if (choice == 1) {
                addEmployee();
            } else if (choice == 2) {
                deleteEmployee();
            } else if (choice == 3) {
                updateEmployee();
            } else if (choice == 4) {
                searchEmployee();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("输入错误，请确认后重新输入");
            }
        }
        System.out.println("*****您已退出员工管理系统*****");
    }
    public static void addEmployee() {
        System.out.println("*****欢迎来到添加员工界面*****");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要添加员工姓名：");
        String name=sc.nextLine();
        System.out.println("请输入需要添加员工性别：");
        String gender =sc.nextLine();
        System.out.println("请输入需要添加员工电话：");
        String phone = sc.nextLine();
        System.out.println("请输入需要添加员工邮箱：");
        String email = sc.nextLine();
        System.out.println("请输入需要添加员工学历数字(1 本科, 2 硕士, 3 博士)：");
        Integer eduBackGround = sc.nextInt();
        System.out.println("请输入签约流程数字(1 面试已通过, 2 已发送offer, 3 背调已完成, 4 三方已签约)：");
        Integer stage = sc.nextInt();
        Employee employee = new Employee(name, gender, phone, email, eduBackGround, stage);
        EmployeeDao employeeDao =new EmployeeDao();
        int line=employeeDao.addEmp(employee);
        if(line>0){
            System.out.println("添加员工成功");
        } else {
            System.out.println("添加员工失败");
        }
    }
    public static void deleteEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****欢迎来到删除员工界面*****");
        System.out.println("请输入需要删除的员工名字");
        String name =sc.nextLine();
        EmployeeDao employeeDao =new EmployeeDao();
        int line=employeeDao.deleteEmpByName(name);
        if(line>0) {
            System.out.println("删除员工成功");
        } else {
            System.out.println("没有找到该员工，无法删除");
        }
    }
    public static void updateEmployee() {
        System.out.println("*****欢迎来到修改员工界面*****");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要修改员工的姓名：");
        String name=sc.nextLine();
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.searchEmpByName(name);
        if (employee == null) {
            System.out.println("该员工不存在，请确认后重新输入");
        } else {
            while (true) {
                System.out.println("*****请输入要修改的信息*****");
                System.out.println("修改性别请按*****1");
                System.out.println("修改电话请按*****2");
                System.out.println("修改邮箱请按*****3");
                System.out.println("修改学历请按*****4");
                System.out.println("修改阶段请按*****5");
                System.out.println("退出输入请按*****6");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("请输入修改后的性别:");
                    employee.setGender(sc.next());
                } else if (choice == 2) {
                    System.out.println("请输入修改后的电话:");
                    employee.setPhone(sc.next());
                } else if (choice == 3){
                    System.out.println("请输入修改后的邮箱:");
                    employee.setEmail(sc.next());
                } else if (choice == 4) {
                    System.out.println("请输入修改后的学历:");
                    employee.setEduBackGround(sc.nextInt());
                } else if (choice == 5) {
                    System.out.println("请输入修改后的阶段:");
                    employee.setStage(sc.nextInt());
                } else if (choice == 6) {
                    break;
                } else {
                    System.out.println("输入错误，请确认后重新输入");
                }
            }
            int line=employeeDao.updateEmp(employee);
            if(line > 0){
                System.out.println("修改员工成功");
            } else {
                System.out.println("修改员工失败");
            }
        }
    }
    public static void searchEmployee() {
        System.out.println("*****欢迎来到查询员工界面*****");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询员工的姓名：");
        String name=sc.nextLine();
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = employeeDao.searchEmpByName(name);
        if (employee == null) {
            System.out.println("暂无数据");
        } else {
            System.out.println("*****查询结果*****");
            System.out.println("员工姓名:" + employee.getName());
            System.out.println("员工性别:" + employee.getGender());
            System.out.println("员工电话:" + employee.getPhone());
            System.out.println("员工邮箱:" + employee.getEmail());
            String eduBackGround = "";
            if (employee.getEduBackGround() == 1) {
                eduBackGround = "本科";
            } else if (employee.getEduBackGround() == 2) {
                eduBackGround = "学士";
            } else {
                eduBackGround = "硕士";
            }
            System.out.println("员工学历:" + eduBackGround);
            String stage = "";
            if (employee.getStage() == 1) {
                stage = "面试已通过";
            } else if (employee.getStage() == 2) {
                stage = "已发送offer";
            } else if (employee.getStage() == 3) {
                stage = "背调已完成";
            } else {
                stage = "三方已签约";
            }
            System.out.println("员工状态:" + stage);
        }
    }
}
