/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.Vector;

/**
 *
 * @author Bluesky
 */
public class Collection_VectorExample1 {
    public static void main(String args[]){
        Vector<String> test=new Vector();
        test.add("1");//vector(0)
        test.add("2");//vector(1)
        test.add("the third number");
        //使用for循环来遍历集合类对象
        for(String day:test){
            System.out.println(day);
        }
    }
}
