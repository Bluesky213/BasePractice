/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Bluesky
 */
public class FileIO_FileReadExample1 {//readLine读出单行文字
    public static void main(String []args) {
        String filename="C:/Users/Bluesky/Desktop/3.txt";//文件中的汉字无法读出
        //只读出单行文本内容
//        try{
//        
//        BufferedReader read=new BufferedReader(new FileReader(filename));
//        String line=read.readLine();//读一行文字
//        System.out.println(line);
//        read.close();
//        }
//逐行读出文本内容
        try{
            BufferedReader read=new BufferedReader(new FileReader(filename));
            String line=read.readLine();
            while(line!=null)
            {
                System.out.println(line);
                line=read.readLine();
             }
}
        catch (IOException e){
        System.out.println("Problem reading "+filename);
        }
    }
}