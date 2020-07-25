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
 * @author Christopher
 */
public class temp1 {
    public static void main(String args[])
    {
        Map<String,Object> map1 = new HashMap();
        Map<String,Object> map2 = new HashMap();
        map2.put("msgId","3");
        map2.put("checkcode","9999");
        map2.put("phone", "13117007990");
        map1.put("datamsg",map2);
        System.out.println(String.valueOf(map1));
    }
}
