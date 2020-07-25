/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

/**
 *不使用除法得到一个整数中各个位的数字的方法——将该数字转换成String类型再转成char[]数组
 * 然后循环得到每个char[i]元素的值并且在运算的时候再将其转换回int类型才能参与运算
 * 本质就是转换成char[]以把每个位的数字分开
 * @author Bluesky
 */
public class getNumberOfEachPlace {
    static int add=0;
    public static void main(String args[])
    {
        int num=52013;
//            String str=num+"";
//            StringBuffer sb=new StringBuffer(str);    
//            StringBuffer rsb=sb.reverse();          
//            System.out.println(rsb);  
        StringBuffer sb=new StringBuffer(String.valueOf(num));
        System.out.println("sb.reverse:  "+sb.reverse());//StringBuffer.reverse()函数将其顺序颠倒
        System.out.println("sb.toString: "+sb.toString());
        char[]  charArray=sb.toString().toCharArray();
        for(int i=0;i<charArray.length;i++)
        {
            add=add+(Integer.valueOf(String.valueOf(charArray[i])));
            System.out.println("charArray["+i+"]:"+charArray[i]);
            //System.out.println("add:"+add);
        }
        //测试将类似 "0 0 3"这样的字符串转换转Integer格式的数字时会不会发生错误
        int []test={1,0,3,4,0,6,7,8};
        System.out.println(Integer.parseInt(String.valueOf(test[1])+String.valueOf(test[4])+String.valueOf(test[2])));
//        System.out.println("add:"+add);
    }
}
