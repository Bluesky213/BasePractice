/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Bluesky
 */
public class calculatemoney {
    public static void main(String args[]){
        Hashtable<Integer,Double> hashtable=new Hashtable<Integer,Double>();
        hashtable.put(1980,0.060);
        hashtable.put(1981,0.024);
        hashtable.put(1982,0.019);
        hashtable.put(1983,0.015);
        hashtable.put(1984,0.028);
        hashtable.put(1985,0.093);
        hashtable.put(1986,0.065);
        hashtable.put(1987,0.073);
        hashtable.put(1988,0.188);
        hashtable.put(1989,0.180);
        hashtable.put(1990,0.031);
        hashtable.put(1991,0.034);
        hashtable.put(1992,0.064);
        hashtable.put(1993,0.147);
        hashtable.put(1994,0.241);
        hashtable.put(1995,0.171);
        hashtable.put(1996,0.083);
        hashtable.put(1997,0.028);
        hashtable.put(1998,-0.008);
        hashtable.put(1999,-0.014);
        hashtable.put(2000,0.004);
        hashtable.put(2001,0.007);
        hashtable.put(2002,-0.008);
        hashtable.put(2003,0.012);
        hashtable.put(2004,0.039);
        hashtable.put(2005,0.018);
        hashtable.put(2006,0.015);
        hashtable.put(2007,0.048);
        hashtable.put(2008,0.059);
        hashtable.put(2009,-0.007);
        hashtable.put(2010,0.033);
        hashtable.put(2011,0.054);
        hashtable.put(2012,0.026);
        hashtable.put(2013,0.032);
        hashtable.put(2014,0.015);
        hashtable.put(2015,0.014);
        hashtable.put(2016,0.03);
        hashtable.put(2017,0.075);
        //hashtable.put(2018,0.06);
        int nowmoney=10000;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入货币现年：");
        int year=scanner.nextInt();
        System.out.println("请输入计算货币：");
        double pastmoney=scanner.nextDouble();
        System.out.println("请输入膨胀结果年：");
        int year_delay=scanner.nextInt();
        double lastmoney=pastmoney;
        for(int i=year;i<year_delay;i++)
        {
            lastmoney=lastmoney*(1-hashtable.get(i));
            System.out.println("循环中的值："+i+"年的值是"+lastmoney);
        }
        System.out.println("计算结果是："+lastmoney);
    }
}
