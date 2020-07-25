package christopher.practice1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bluesky
 */
public class mathproblem {
    public static void main(String []args){
    int a=23;
    int b=5;
    int c=7;
    int d=45;
    int f=2;
    String g="02";
    System.out.println(Math.pow(((a+Math.pow(b, c))/d),f));
    System.out.println(Math.pow(((23+Math.pow(5, 7))/45),2));
    System.out.println(23/5);
    System.out.println(Integer.parseInt(g));
    System.out.println(Integer.valueOf(g));
    }
}
