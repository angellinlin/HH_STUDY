package demo07;
/*�ӿ���Ϊ�����Ĳ���*/
import java.util.ArrayList;
import java.util.List;
/*
* java.util.list ����ArrayList��ʵ�ֵĽӿڡ�
* */
public class DemoInterface {
    public static void main(String[] args) {
        //����ǽӿڵ����ƣ��ұ���ʵ�������ƣ����Ƕ�̬��д��
        List<String> list=new ArrayList<>();
        List<String> result=addName(list);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }

    public static List<String> addName(List<String> list){
        list.add("dora");
        list.add("linda");
        list.add("tom");
        return list;

    }
}
