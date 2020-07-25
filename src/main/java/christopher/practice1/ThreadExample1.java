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
public class ThreadExample1 {
    public static void main(String args[]){

        System.out.println("main thread starts");
        ThreadClass thread=new ThreadClass(10);
        try{Thread.sleep(3000);}
        catch (Exception e){};
        thread.start();
        System.out.println("main thread ends");
    }
}

class ThreadClass extends Thread{
    private int num;
    public ThreadClass(int num){
        this.num=num;
    }
    @Override
    public void run(){
        int i=num;
        int result=1;
        System.out.println("new thread started");
        while(i>0){
            result=result*i;
            i=i-1;
        }
        System.out.println("The factorial of "+num+" is "+result);
        System.out.println("new thread ends");
    }
}
    
    //即多线程的类似结构如下

    //public class 第一个类 {
        //public static void main(String args[]){
        //用第二个类实例化一个thread对象
        //第二个类 对象=new 第二个类(10);
        //对象.start();
        //}
    //}

    //class 第二个类 extends Thread{
        //定义方法或者变量
        //@Override
        //public void run()
        //{
            //这里写要执行的代码
        //}
    //}

