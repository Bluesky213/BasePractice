package christopher.practice1;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaExpression {
    List<Map<String,Object>> list1 = new LinkedList<Map<String, Object>>();
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<Map<String,Object>> mapList = new LinkedList<Map<String, Object>>();
        for(int i=0;i<10;i++) {
            Map<String,Object> map1 = new HashMap<>();
            map1.put("name", i);
            map1.put("code", "code" + i);
            mapList.add(map1);
        }
        mapList.forEach(System.out::println);
        // Collection.stream().action(xxxxxx).collect(Collectors.AimData);
        List<Map<String,Object>> maps = mapList.stream().filter(map1->map1.get("name").toString().equals("1")).collect(Collectors.toList());
//        System.out::println(maps);
        List<String> list = Arrays.asList("123","456","789","1101","212121121","asdaa","3e3e3e","2321eew");
    }


}
