/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.util.Arrays;

/**
 *
 * @author Bluesky
 */
//全排列算法————字典序
public class dictorySerial1 {
    public static void main(String args[]) {
        int[] ary1={1,2,5,4,3};
        
        Arrays.sort(ary1); 
        System.out.println("1:" + Arrays.toString(ary1)); //ary1转成字符串格式
        int i = 2; 
        while (true) {
            int j; 
            for (j = 5 - 1; j > 0; j--) {//j用作ary1的下标[array.length,1]
                if (ary1[j - 1] < ary1[j]){//[array[0],array[array.length]//如果数组的前一项比后一项小
                    for (int k = 5 - 1; k > j - 1; k--) //k[array.length-1,j-1]//j=array.length-1
                    {
                        if (ary1[k] > ary1[j - 1])//如果array[k]>array[j-1]——也就是如果前一项比后一项小 就交换
                        {
                            int temp = ary1[j - 1]; 
                            ary1[j - 1] = ary1[k]; 
                            ary1[k] = temp; 
                            break; //交换完成就break;
                        }
                    }
                    
                    int[] ary2 = new int[5 - j]; 
                    System.arraycopy(ary1, j, ary2, 0, ary2.length); //[] [] [] [] [] —— 【】 【】 【】 【】 【】
                    Arrays.sort(ary2); //按照字典序进行排列的
                    System.arraycopy(ary2, 0, ary1, j, ary2.length); //将排列好的字典序再插入到ary1中j开头的起始位置
                    System.out.println((i++) + ":" + Arrays.toString(ary1)); 
                    break; 
                } 
            }
            if (j == 0) {//数组仅有一个元素不排列
                break; 
            } 
        }
    }
}
