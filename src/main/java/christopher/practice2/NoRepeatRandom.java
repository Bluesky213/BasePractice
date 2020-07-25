/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.util.Vector;

/**
 *
 * @author Bluesky
 */
public class NoRepeatRandom {
    public static void main(String args[]){
        Vector vector=new Vector();
        vector.add("0");
        vector.add("1");
        vector.add("2");
        vector.add("3");
        //本程序可以生成不重复的随机数
        //首先通过Vector.size方法得到Vector对象的大小作为随机数的最大范围+1
        //通过随机数生成随机的Vector对象的下标，然后输出get对象得到的下标
        //然后用remove移除对应下标的元素
        int c=1;
        for(int i=vector.size();i>0;i--)
        {
            int vectorsize=vector.size();
            System.out.println("第"+c+++"轮随机:");
            System.out.println("Vector元素个数："+vectorsize);
            int x=(int) (Math.random() * vectorsize+1);
            System.out.println("生成的随机数x是："+x);
            System.out.println("被移除的元素是："+vector.get(x-1));
            System.out.println("");
            vector.remove(x-1);
        }
    }
}
