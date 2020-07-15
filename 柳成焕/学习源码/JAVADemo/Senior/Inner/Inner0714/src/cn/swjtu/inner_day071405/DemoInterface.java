package cn.swjtu.inner_day071405;

import java.util.ArrayList;
import java.util.List;

public class DemoInterface {
    public static void main(String[] args) {
        //左边是接口名称，右边是实现类名称，多态
        List<String> list = new ArrayList<String>();
        List<String> result = addList(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<String> addList(List<String> list) {

        list.add("孙尚香");
        list.add("王昭君");
        list.add("庄周");
        list.add("亚瑟");
        return list;
    }
}
