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
public class ArrayIndexOutOfBoundExceotionExample {
    public static void main(String[] args) {
        int list[] = { 1, 2, 3, 4 };
        for (int i = 0; i < 5; i++)
            System.out.print(list[i]);
    }
}
