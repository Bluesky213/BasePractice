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
public class RandomNumber {
    public static void main(String args[]){
        //float total = 0;
        //for(int m=0;m<200;m++)
        //{
        int yes=0,no=0;
        for(int i=0;i<500;i++)
        {
            int number;
            number=(int) (Math.random() * 100);//使用随机数时要用括号把整个获得随机数的部分括起来
            if(number<55)
            {
                //System.out.println("Just do it");
                yes++;
            }
            else 
            {
                //System.out.println("Relax yourself");
                no++;
            }
                
        }
        System.out.println(" ");
        System.out.println("Yes:"+yes);
        System.out.println("No:"+no);
        System.out.println("Yes/No:"+Float.valueOf(yes)/Float.valueOf(no));
        //total=total+Float.valueOf(yes)/Float.valueOf(no);
        }
        //System.out.println("最后平均数："+total/200);
    //}
    
    
    
    
}
