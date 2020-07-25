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
//二位数组的全排列——尝试用两个变量去描述数组的变化，在遇到以后一列时(row+1,col=0),其它都是（row,col+1)
public class arrangementTest4_SecondDimensionArray {
     static int count=0;
    public static void main(String args[])
    {
        int box[][]= {{1,2,3},{4,5,6},{7,8,9}};
        dfs(box,0,0);
        System.out.println(count);
    }
    
    public static void dfs(int array[][],int deepthi,int deepthj)
    {
        if(deepthi>=array.length||deepthj>=array[0].length)
        {
            for(int array1[]:array)
                {
                    for(int array2:array1)
                    {
                        System.out.print(array2);
                    }
                }
            System.out.println();
            count++;
            return;
        }
        
        for(int row=deepthi;row<array.length;row++)
        {
            for(int col=deepthj;col<array[0].length;col++)
            {
                    int temp=array[deepthi][deepthj];
                    array[deepthi][deepthj]=array[row][col];
                    array[row][col]=temp;
                    if(row<array.length&&col<array[0].length-1)
                    {
                        dfs(array,deepthi,deepthj+1);
                    }
                    if(col==array[0].length-1)
                    {
                        dfs(array,deepthi+1,0);
                    }
                    
//                    if(row==array.length-1)
//                    {
//                        dfs(array,deepthi,deepthj+1);
//                    }
//                       else dfs(array,deepthi+1,deepthj+1);
                    temp=array[deepthi][deepthj];
                    array[deepthi][deepthj]=array[row][col];
                    array[row][col]=temp;
            }
        }
}
}
