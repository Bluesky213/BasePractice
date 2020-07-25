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

public class InputExample {
	public static void main(String[] args) {
		System.out.println("即将从键盘输入一个值：");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		System.out.println(a);
	}
}