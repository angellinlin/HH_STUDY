package demo01;
/*
* ���ڳ�Ա���������ʹ��final�ؼ������Σ���ô����Ҳ�����ǲ��ɱ�
* 1.���ڳ�Ա��������Ĭ��ֵ����������final֮������ֶ���ֵ�������ٸ�Ĭ��ֵ
* 2.����final �ĳ�Ա������Ҫôֱ�Ӹ�ֵ��Ҫôʹ�ù��췽����ֵ
* 3.���뱣֤�൱���������صĹ��췽���������ջ��final�ĳ�Ա�������и�ֵ�����ҽ���һ�θ�ֵ
* */
public class Person {
    //1.ֱ�Ӹ�ֵ�����췽����ֵ���Լ�set�������и�ֵ��������
    //private final String name="¹��";
    private final String name;
    public Person(){
        name="����ͮ";
    }

    public Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

  /*  public void setName(String name) {
        this.name = name;
    }*/
}
