/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bluesky
 */
public class Collection_MapExample {
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<String, String>();
//使用put添加元素  
        map.put("name", "张三");
        map.put("sex", "男");
        map.put("age", "12");
        map.put("addres", "深圳");
        map.put("iPhone", "13068706819");
//存放两个key-value为空的元素，打印时出现一个  
        map.put(null, null);
        map.put(null, null);

//打印出来元素是先进后出排序  
        System.out.println("HashMap存放元素规则是先进后出：" + map);
        System.out.println(map.get("addres"));
        
        Map map2=new HashMap();
    }
}
