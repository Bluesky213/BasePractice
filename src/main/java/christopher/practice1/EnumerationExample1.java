/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.Enumeration;
import java.util.Vector;
//Enumeration 接口是Iterator迭代器的“古老版本”，从JDK 1.0开始，Enumeration接口就已经存在了（Iterator从JDK 1.2才出现）。Enumeration接口只有两个方法。?
//boolean hasMoreElements() 

//如果此迭代器还有剩下的元素，则返回true 
//Object nextElement() 
//返回该迭代器的下一个元素，如果还有的话(否则抛出异常)

//通过这两个方法不难发现，Enumeration接口中的方法名称难以记忆，而且没有Iterator的remove()方法。如果现在编写Java程序，应该尽量采用Iterator迭代器，而不是用Enumeration迭代器。

//之所以保留Enumeration接口的原因，主要为了照顾以前那些“古老”的程序，那些程序里大量使用Enumeration接口，如果新版本的Java里直接删除Enumeration接口，将会导致那些程序全部出错。

/**
 *
 * @author Bluesky
 */
public class EnumerationExample1 {
    public static void main(String args[]){
        Enumeration<String>days;
        Vector<String>dayNames=new Vector<String>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days=dayNames.elements();
        while(days.hasMoreElements())
        {
            System.out.println(days.nextElement());
        }
    }
}
