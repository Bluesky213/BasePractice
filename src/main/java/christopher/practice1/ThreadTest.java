/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.util.Scanner;

/**
 *
 * @author Bluesky
 */
class SyncThreadTest implements Runnable{
    public static int count=0;
    public void run()
    {
        System.out.println("--------------"+Thread.currentThread().getName()+"正在运行");
        for(int i=0;i<100000;i++)
        {
            System.out.println("The value of i:"+i);
        }
    }
}

public class ThreadTest {
    public static void main(String args[]) throws InterruptedException{
        //主方法
        SyncThreadTest sync1=new SyncThreadTest();
     
        Thread thread1=new Thread(sync1);
        thread1.start();
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        
        if(a==0)
        {
            thread1.wait();
        }
    }
}
