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
//用于去重的全排序工作，与上一个全排列程序相比增加了一个checkRepet()函数用于检验
//从下标start——end之间是否有元素重复，如果有就不计数不输出(依次传入
public class arrangementTest3_RepeatRemoved {
static int count;
    public static void main(String args[])
    {
        char [] array={'1','1','1','1','2','2','3','3'};
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
            if(checkRepeat(array,deepth,i))
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
    //用于检验从a[deepth]——a[i]这个过程之间有没有元素重复
    public static boolean checkRepeat(char checkArray[],int start,int end)//如果没有重复返回true
    {
        boolean ok=true;
        for(int i=start;i<end;i++)
        {
            if(checkArray[i]==checkArray[end])
                ok=false;
        }
        return ok;
    }
}
