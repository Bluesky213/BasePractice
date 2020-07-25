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
class SyncThread implements Runnable {//一个class
	   private static int count;
 
	   public SyncThread() {//构造方法
	      count = 0;
	   }
 
	   public  void run() {//SyncThread这个类中的run()方法
	      synchronized(this) {
	         for (int i = 0; i < 5; i++) {
	            try {
	               System.out.println(Thread.currentThread().getName() + ":" + (count++));
	               Thread.sleep(100);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
 
	   public int getCount() {
	      return count;
	   }
}

public class ThreadSynchronizedExample {
	public static void main(String args[]){
//test01//用两个不同的 包含run()方法的 类对象去创建两个线程，两个线程的Count变量是共用的
//		SyncThread s1 = new SyncThread();
//		SyncThread s2 = new SyncThread();
//		Thread t1 = new Thread(s1);
//		Thread t2 = new Thread(s2);
//test02//用一个相同的 包含run()方法的 类对象去创建两个线程,等第一个线程执行完才会执行第二个或者说两个线程的count变量是分开的不共享的
		SyncThread s = new SyncThread();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		
		t1.start();
		t2.start();
	}
}
