package demo04;
/*��β���֪��һ���������õĶ��󣬱�����ʲô����
* ��ʽ��
*���� instanceof ������
* ����һ��booleanֵ��Ҳ�����ж�ǰ��Ķ����ܲ��ܵ����������͵�ʵ��
*
*
* */


public class Demo02Instanceof {
    public static void main(String[] args) {
        Animal animal=new Cat();
        animal.eat();//è����

        //��ȫ����ת��
        //�жϸ�������animal�����ǲ���Dog
        if(animal instanceof Dog){
            Dog dog=(Dog) animal;
            dog.watchHouse();
        }
        if(animal instanceof Cat){
            Cat cat=(Cat) animal;
            cat.catchMouse();
        }
    }

    public static void giveMyPet(Animal animal){
        if(animal instanceof Dog){
            Dog dog=(Dog) animal;
            dog.watchHouse();
        }
        if(animal instanceof Cat){
            Cat cat=(Cat) animal;
            cat.catchMouse();
        }
    }
}
