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
//全排列算法————字典序————深度优先算法的案例
public class arrangementTest1_alphabetOrder {
    static int count;
    public static void main(String args[])
    {
        char [] array={'1','2','3','4','5','6'};
        dfs(array,0);
        System.out.println(count);
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
}
