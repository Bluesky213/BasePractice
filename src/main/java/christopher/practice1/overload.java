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
public class overload {
    public void receive(int i){
    System.out.println("Receive one int parameter.");
    System.out.println("i="+i);
    }
    public void receive(double d){
    System.out.println("Receive one double parameter.");
    System.out.println("d="+d);
    }
    public void receive(String d){
    System.out.println("Receive one double parameter.");
    System.out.println("s="+d);
    }
    public void receive(int i,int j){
    System.out.println("Receive two int parameter.");
    System.out.println("i="+i+"j="+j);
    }
    public void receive(int i,double d){
    System.out.println("Receive one int parameter and one double parameter.");
    System.out.println("i="+i+"d="+d);
    }
    
    public static void main(String [] args){
    overload m=new overload();
    m.receive(2);
    m.receive(5.6);
    m.receive(3,4);
    m.receive(7,8.2);
    m.receive("Is it fun?");
    }
}
