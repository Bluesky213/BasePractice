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
public class ThreadExample3  
{  
    public static void main(String[] args)  
    {  
        ThreadB b = new ThreadB();
        Threadc c = new Threadc();
        c.setName("c线程");  
        b.setName("b线程");  
        c.start();
        System.out.println(Thread.currentThread().getName()+" is start....");  
          
        synchronized(c)  
        {  
            try  
            {  
                System.out.println("waiting for b1 to complete....");  
                c.wait(); 
                System.out.println("Completed.now back to "+  
                        Thread.currentThread().getName());  
                b.start();  
            }  
            catch(InterruptedException e)  
            {  
            }  
    }  
}  
}

class ThreadB extends Thread  
{  
    int total;  
    public void run()  
    {  
        synchronized(this)  
        {  
            System.out.println(Thread.currentThread().getName()+"is running..");  
            for(int i=0;i<10;i++)  
            {  
                total +=i;  
            }  
            System.out.println("total is"+total);  
        }  
    }  
}

class Threadc extends Thread  
{  
    int sum=1;  
    public void run()  
    {  
        synchronized(this)  
        {  
            System.out.println(Thread.currentThread().getName()+"is running..");  
            for(int i=1;i<10;i++)  
            {  
                sum *=i;  
            }  
            System.out.println("sum is"+sum);  
            notify();  
        }  
    }  
}  
