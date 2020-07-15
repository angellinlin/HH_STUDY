package cn.swjtu.Generic_day0715;
/*
定义一个含有泛型的类，模拟ArrayList集合
 */
public class Generic<E> {
    private E name;

    public Generic() {

    }

    public Generic(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
