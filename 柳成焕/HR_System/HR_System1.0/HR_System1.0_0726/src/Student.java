/*
创建一个学生类，存储：
    编号int id
    姓名String name
    性别boolean male;
    年龄int age;
 */
public class Student {
    private int id;
    private String name;
    private boolean male;
    private int age;

    public Student() {

    }

    public Student(int id, String name, boolean male, int age) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isMale() {
        if(male==true){
            return "男";
        }else{
            return "女";
        }
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", male=" + male +
                ", age=" + age +
                '}';
    }
}
