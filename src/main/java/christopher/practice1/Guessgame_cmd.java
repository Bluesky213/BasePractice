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

import java.util.Scanner;

public class Guessgame_cmd{
	public static void main(String[] args){
	Guessgame_cmd player1=new Guessgame_cmd();
	player1.guess();
	}
    public void guess(){
	//int a;
	//scanf("%d",&a);
	//以下是从键盘输入数据
	

	System.out.println("Please guess a number:");
	Scanner in=new Scanner(System.in);
	int a=in.nextInt();
	in.close();
	int b=(int)(Math.random()*10);
if(a==b)
	{
	System.out.print("Congratulations!The random number is:");
	System.out.print(b);
	}
else
	{
		System.out.print("Sorry,you are wrong,the random number is:");
		System.out.print(b);
		}
	}
}
