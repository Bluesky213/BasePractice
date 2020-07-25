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
public class convertString {
    public static void main(String args[]){
        String sample="lu<?>__+__+mmiwantt))()(&*ofuck";
        System.out.println(convert(sample));
    }
    public static String convert(String myString)
    {
        int length=myString.length();
        int p=0;
        int q=0;
        char array1[] = null;
        char array2[] = null;
        //myString.toCharArray();
        char myString_char[]=myString.toCharArray();
        for(int i=0;i<length;i++)
        {
            if((myString_char[i]>=65&&myString_char[i]<=90)||(myString_char[i]>=97&&myString_char[i]<=122))
            {
                array1[p]=myString_char[i];
                p++;
            }
            else
            {
                array2[q]=myString_char[i];
                q++;
            }
        }
        int y=0,z=0;
        for(int x=0;x<length;x++)
        {
            if(p-1>x)
            {
                myString_char[x]=array1[y];
                y++;
            }
            else
            {
                myString_char[x]=array2[z];
                z++;   
            }
        }
        String result=myString_char.toString();
        return result;
    }
}
