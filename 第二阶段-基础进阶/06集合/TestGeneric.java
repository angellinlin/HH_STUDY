package cn.com.spdb.testidea09;

public class TestGeneric<E> {

    private E name;

    public TestGeneric(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestGeneric{" +
                "name=" + name +
                '}';
    }
}
