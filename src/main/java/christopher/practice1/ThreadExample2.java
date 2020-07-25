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
public class ThreadExample2 {
    public static void main(String args[]){
        ThreadMaker thread1=new ThreadMaker("thread1");
        ThreadMaker thread2=new ThreadMaker("thread2");
        ThreadMaker thread3=new ThreadMaker("thread3");
        System.out.println("Starting threads");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Threads started,main ends\n");
    }
}

class ThreadMaker extends Thread{
    private int sleepTime;
    public ThreadMaker(String name){
        super(name);
        sleepTime=(int)(Math.random()*6000);
    }
    @Override
    public void run(){
        try
        {
            System.out.println(getName()+" going to sleep for "+sleepTime);
            Thread.sleep(sleepTime);
        }catch(InterruptedException exception)
        {
            
        }
        System.out.println(getName()+"finished");
    }
}

