/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.util.Scanner;

/**
 *
 * @author Bluesky
 */
public class calculateMoneyOfEconomicLever {
    public static void main(String args[]){
        float rate;
        float money=100;
        float lastmoney=0;
        int times;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入准备金率：");
        rate=scanner.nextFloat();
        System.out.println("请输入杠杆次数：");
        times=scanner.nextInt();
        for(int i=1;i<=times;i++)
        {
            double x;
            x=money*Math.pow(rate,i);
            lastmoney+=x;
            System.out.println("第"+i+"次杠杆之后的值是："+(lastmoney+money));
            
        }
        //System.out.println(money); 
    }
    
}
