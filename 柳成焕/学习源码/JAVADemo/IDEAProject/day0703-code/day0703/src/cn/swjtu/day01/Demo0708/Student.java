package cn.swjtu.day01.Demo0708;
/*
对于基本数据类型中的boolean类型。在get方法中一定要写成is***
而set方法与原来一致。
 */
public class Student {
    private String name;
    private int age;
    private boolean male;  //性别

    public void setName(String str){
        name=str;
    }

    public String getName(){
        return name;
    }

    public void setAge(int num){
        age=num;
    }

    public int getAge(){
        return age;
    }

    public void setMale(boolean b){
        male=b;
    }

    public boolean isMale(){
        return male;
    }
}
