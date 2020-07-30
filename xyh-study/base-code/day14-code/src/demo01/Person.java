package demo01;

import java.util.Objects;

public class Person /*extends Object*/ {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /*һ�㶼�Ƿ���falseֵ������û�����壬��Ҫ��дequals����,�Ƚ��������������
    ����һ����̬�����⣺�޷�ʹ���������е����ݣ����Ժͷ�����
    Object object=new Person("Dora",18);
    �������������ʹ������ת�ͣ�ǿ��ת�ͣ���obj������ת��ΪPerson��*/
/*    @Override
    public boolean equals(Object object){
        //����һ���жϣ����ݲ���Ϊ����ֱ�ӷ���ture����߳����Ч��
        if(object.equals(this)){
            return true;
        }
        //����һ���жϣ����ݲ���Ϊ�գ�ֱ�ӷ���false,��߳���Ч��
        if(object==null){
            return false;
        }
        //����һ���жϣ���ֹ����ת���쳣
        if(object instanceof Person){
            //ʹ������ת��
            Person p=(Person)object;
            //�Ƚ��������������
            boolean b=(this.name.equals(p.name))&&(this.age==p.age);
            return b;
        }
        return false;

    }*/
    //ʹ�ÿ�ݼ�Ҳ������дeaquals����
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //ֱ�Ӵ�ӡObject���toString����û�����壬��Ҫ��д
    /*@Override
   public String toString(){

        return "Person(name="+name+",age="+age+")";
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }




}
