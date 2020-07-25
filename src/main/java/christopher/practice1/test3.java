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

    class A1{
        int x=2;
        public void setx(int i){
        x=i;
        }
        void printa(){
        System.out.println(x);
        }
    }

class B1 extends A1 {
    int x=100;
    void printb(){
    super.x=super.x+10;
    System.out.println(" super.x="+super.x+" x="+x);
    }
}


public class test3 {
    public static void main(String[] args){
        A a1=new A();
        a1.setx(4);                     //set x=4;（a1）
        a1.printa();                    //输出：4
        B b1=new B();                   //new一个B的实例b1
        b1.printb();                    //12        //100
        b1.printa();                    //12
        b1.setx(6);
        b1.printb();                    //16        //100        
        b1.printa();                    //16 即使引用的时候也是引用的A里面的值而不是B里面x变量的值？？？
        a1.printa();                    //4
    }
}
