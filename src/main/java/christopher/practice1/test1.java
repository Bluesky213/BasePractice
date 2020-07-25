/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

/**
 *
 * @author Bluesky
 */
public class test1 { 
    public static void main(String args[]) {
      byte b=0x55;
      short s=0x055; 
      int i=1111111111; 
      long l=0xffffl; 
      char c='a'; 
      float f=0.23F; 
      double d=0.7E-3; 
      boolean B=true; 
      String S="这是字符串类数据类型"; 
      System.out.println("字节型变量 b = "+b); 
      System.out.println("短整型变量 s = "+s); 
      System.out.println(" 整型变量 i = "+i); 
      System.out.println("长整型变量 l = "+l); 
      System.out.println("字符型变量 c = "+c); 
      System.out.println("浮点型变量 f = "+f); 
      System.out.println("双精度变量 d = "+d); 
      System.out.println("布尔型变量 B = "+B); 
      System.out.println("字符串类对象 S = "+S); 
      System.out.println(Integer.MAX_VALUE);
      System.out.println(Float.MAX_VALUE);
      System.out.println(Double.MAX_VALUE);
      System.out.println(2E3);//2 * 10的3次方 E3=10^3
      System.out.println(2<<8);//00000002 将2向左移动2位 从2的二零次方变成2的二次方
    } 
  } 

