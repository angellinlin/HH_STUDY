package demo02;

public class Body {//�ⲿ��


    public class Heart{//��Ա�ڲ���
        public void beat(){
            System.out.println("�����������ııģ�");
            System.out.println("�ҽУ�"+name);//��ȷд��
        }

    }

    private String name;
    public void methodBody(){
        System.out.println("�ⲿ�ڵķ���");
        new Heart().beat();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
