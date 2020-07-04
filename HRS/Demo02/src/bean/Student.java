package bean;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/4 17:46
 * @modified By：
 */
public class Student {
    //学生信息
    private String studentName;
    private String studentID;
    private String position;



    @Override
    public String toString() {
        return "学生信息{" +
                "姓名='" + studentName + '\'' +
                ", 身份证号码='" + studentID + '\'' +
                ", 应聘岗位='" + position + '\'' +
                '}';
    }

    public Student() {
    }

    //使用构造方法为学生信息赋值
    public Student(String studentName, String studentID,String position) {
        setStudentName(studentName);
        setStudentID(studentID);
        setPosition(position);
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
