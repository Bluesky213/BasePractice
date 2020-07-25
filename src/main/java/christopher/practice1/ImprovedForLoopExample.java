/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.Arrays;

/**
 *
 * @author Bluesky
 */
public class ImprovedForLoopExample {
    public static void main(String args[]){
        //for(element type:array)
        int[] array1=new int[10];
        for(int m:array1)
        {System.out.println(array1[m]);}//没有赋值的数组元素全部为0
        int[] array2={1,2,3,4,5,6,7,8,9,10};
        for(int n:array2)//把n当成其中要遍历的元素而不是数组下标
        {System.out.println(n);}
         
        String stringArr[]={"beauty","dislike","most","intercourse"};
        Arrays.sort(stringArr);//Arrays.sort()方法可以对数组快捷排序
        for(String element:stringArr)
        {
            System.out.println(element);
        }
    }
    
}
