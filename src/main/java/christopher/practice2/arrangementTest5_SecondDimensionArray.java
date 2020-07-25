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
public class arrangementTest5_SecondDimensionArray {
     static int count=0;
    public static void main(String args[])
    {
        int box[][]= {{1,2,3},{4,5,6},{7,8,9}};
        for(int a:(transferArrayToOneDimension(box)))
            System.out.println(a);
        //System.out.println(count);
    }
    
public static void dfs(char array[],int deepth)
    {
        if(deepth>=array.length)
            {
                for(int k=0;k<array.length;k++)
                {
                    System.out.print(array[k]);
                    
                }
                    System.out.println();
                    count++;
                return;
            }
        for(int i=deepth;i<array.length;i++)
        {
            char temp=array[i];
            array[i]=array[deepth];
            array[deepth]=temp;
            dfs(array,deepth+1);
            temp=array[i];
            array[i]=array[deepth];
            array[deepth]=temp;
        }
    }
    public static int[] transferArrayToOneDimension(int array[][])
    {
        int array3[]=null;
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++)
            {
                array3[(i*array[0].length+j)]=array[i][j];
            }
        }
         return array3;
    }
}
