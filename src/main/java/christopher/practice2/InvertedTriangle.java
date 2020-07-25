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
public class InvertedTriangle {
    public static void main(String args[]){
    Scanner scanner=new Scanner(System.in);
    int n=scanner.nextInt();
    for(int i=n;i>0;i--)
    {
        for(int x=0;x<n-i;x++)
            System.out.print(" ");
        for(int j=2*i-1;j>0;j--)
            System.out.print("#");
        for(int x=0;x<n-i;x++)
            System.out.print(" ");
        System.out.println(" ");
        }
    }
}
