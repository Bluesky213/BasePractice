/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christopher
 * This example introduces the Generics(泛型) and instanceof
 * 1.new ArrayList() is able to add different type of Objects. Integer cannot be cast to String
 * 2.Object.getClass() is able to get the type(类型) of the Object.
 * 3.instanceof： 二元操作符,类似于 “==，>” object instanceof Class
 */
public class Generics {
    public static void main(String args[]){
        List list = new ArrayList();
        list.add("test");
        list.add(123);
        int c = 1;
        list.add(c);
        System.out.println(list.get(0));
//        System.out.println((String)list.get(1));//Integer cannot be cast to String.
        System.out.println(list.get(0).getClass());
        if(list.get(1) instanceof Integer)
        System.out.println(list.get(1).getClass());
        System.out.println(4.3333333);
        System.out.println(String.valueOf(4.3333333));
    }
}
