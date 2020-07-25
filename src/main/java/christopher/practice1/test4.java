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
public class test4 {
    public static void main(String [] args){
        test8 test8=new test8();
        test9 test9=new test9();
        
        test8.printa();
        test9.printa();
        test9.printa1();
    }
    

}

class test8{
    int a=10;
    public void printa(){
        System.out.println(a);
    }
}

class test9 extends test8 {
    int a=100;
    public void printa(){
        System.out.println(a);
    }
    public void printa1(){
    System.out.println(super.a);
    }
}
