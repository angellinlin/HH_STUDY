package cn.swjtu.Map_day071706;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
新特性：
List接口、Map接口、Set接口：增加了一个静态方法of，可以给集合一次性添加多个元素。
static <E> list<E> of(E...elements)
使用前提：当集合中存储的元素个数已经确定了，不再改变时使用。
注意事项：
    1.of方法只适用于List接口、Map接口、Set接口，不适用于接口的实现类；
    2.of方法的返回值是一个不能改变的集合，集合不能再使用add，put添加元素，会抛出异常；
    3.Set接口和map接口在调用of方法时，不能有重复的元素，否则会抛出异常。

 */
public class DemoJDK9 {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "cc", "d");
        System.out.println(list);  //[a, b, cc, d]
        // list.add("1233"); //UnsupportedOperationException不支持操作异常
        //Set<Integer> set=Set.of(10,2,34,10);//IllegalArgumentException非法参数异常，有重复的元素
        Set<Integer> set = Set.of(10, 2, 34);
        System.out.println(set);
        //set.add(29);UnsupportedOperationException
        //Map<String,Integer> map=Map.of("大乔",18,"小乔",15,"大乔",19);  IllegalArgumentException
        Map<String, Integer> map = Map.of("大乔", 18, "小乔", 15);
        System.out.println(map);
        //map.put("张三", 20); //UnsupportedOperationException
    }
}
