package bean;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/9 17:34
 * @modified By：
 */
public class Student {
    private String name;
    private String id;
    private String position;

    @Override
    public String toString() {
        return "学生信息{" +
                "姓名：" + name + '\'' +
                ", 身份证：'" + id + '\'' +
                ", 应聘职位：" + position + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String name, String id, String position) {
        setName(name);
        setId(id);
        setPosition(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
