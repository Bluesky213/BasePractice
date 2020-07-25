/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Bluesky
 */

public class Collection_SetExample {

    public static void main(String args[]) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 6; i++) {
            set.add(i + "");
        }
        set.add("3");       //重复数据，不会写入  
        set.add(null);      //可以写入空数据  
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());        //输出是无序的  
        }
    }
}
