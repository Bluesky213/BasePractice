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
public class violentSearchTimeTest {
    //次题目对应纸牌那道题目
    static int count = 0;  
    public static void main(String args[])
    {
        
        for(int x1=0;x1<1;x1++)
        {
        //for(int x=0;x<10;x++)
        //{
        
            cal();
        //}
        }
        System.out.println(count / 6);// 旋转是三种相同的，镜像也是三种相同的。所以除以6  //除以3排除旋转，除以2排除镜像
    }
    public static void cal()//其中包含10^9个也就是1000000000（10亿次）  10亿次可秒出结果（稳妥在9次次方)
    {
        for (int i = 1; i < 10; i++) {  //1
            for (int j = 1; j < 10; j++) { //2 
                for (int k = 1; k < 10; k++) { //3 
                    for (int l = 1; l < 10; l++) {//4  
                        for (int m = 1; m < 10; m++) {//5  
                            for (int n = 1; n < 10; n++) {//6  
                                for (int o = 1; o < 10; o++) {//7  
                                    for (int p = 1; p < 10; p++) {//8  
                                        for (int q = 1; q < 10; q++) {//9 
                                            if ((i + j + k + l) == (l + m + n + o) && (i + j + k + l) == (o + q + p + i)  
                                                    && i != j && i != k && i != l && i != m && i != n && i != o  
                                                    && i != p && i != q && j != k && j != l && j != m && j != n  
                                                    && j != o && j != p && j != q && k != l && k != m && k != n  
                                                    && k != o && k != p && k != q && l != m && l != n && l != o  
                                                    && l != p && l != q && m != n && m != o && m != p && m != q  
                                                    && n != o && n != p && n != q && o != p && o != q && p != q) {  
                                                count++;  
                                            }  
                                        }  
                                    }  
                                }  
                            }  
                        }  
                    }  
                }  
            }  
        }
    }
}
