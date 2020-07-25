/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Bluesky
 */
public class EnumerationExample2 {
    public static void main(String args[]){
        String []num={"one","two","three","four","five","six","seven","eight","nine","ten"};
        Vector<String>aVector=new Vector<String>(java.util.Arrays.asList(num));
        System.out.println("Before Vector:"+aVector);
        Enumeration<String>nums=aVector.elements();
        while(nums.hasMoreElements()){
            String aString=nums.nextElement();
            System.out.println(aString);
            if(aString.length()>4)
            {
                aVector.remove(aString);
            }
        }
        System.out.println("After Vector:"+aVector);
    }
    
}
