/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

/**
 *
 * @author Bluesky
 */
public class SingleNumber {
    //素数的定于：除了1和它本身之外不能被任何数整出的数（1除外）
    public static void main(String args[]){
        SingleNumber singlenumber=new SingleNumber();
        int m=100;
        for(int i=2;i<m;i++)
        {
            if(singlenumber.check(i))
            {
                System.out.println(i);
            }
        }
    }
    public boolean check(int i){
        boolean result=true;
        for(int j=2;j<i;j++)
        {
            if(i%j==0)
            result=false;
        }
        return result;
    }
}
