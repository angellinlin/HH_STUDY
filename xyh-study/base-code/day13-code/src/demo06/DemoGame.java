package demo06;

public class DemoGame {
    public static void main(String[] args) {
        //����һ��Ӣ�۽�ɫ
        Hero hero=new Hero();
        hero.setName("��ϣ");
        //һ��ʹ��ʵ��������Ӣ�ۼ���
        //hero.setSkill(new Skillimpl());
        //����ʹ���ڲ�������Ӣ�ۼ���
        /*Skill skill =new Skill(){
            public void use(){
                System.out.println("Biu~Biu~Biu~");
            }
        };
        hero.setSkill(skill);*/

        //ʹ��������������Ӣ�ۼ���
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("Biu~Biu~Biu~");
            }
        });

        hero.attak();

    }
}
