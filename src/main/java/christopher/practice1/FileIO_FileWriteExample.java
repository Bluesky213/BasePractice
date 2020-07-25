/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Bluesky
 */
public class FileIO_FileWriteExample {
    public static void main(String []args){
        String filename="C:/Users/Bluesky/Desktop/2.txt";
        try{
        FileWriter writer=new FileWriter(filename,true);//加了true参数可以实现续写的功能，因为对应了FileWriter()构造函数的形参列表(String,boolean)
        writer.write("Hello!\n");
        writer.write("This is my first text file,\n");
        writer.write("You can see how this is done");
        writer.close();
        }
        catch (IOException e){ //如果文件出现错误，则屏幕显示提示信息
        System.out.println("Problem writing"+filename);
        
        }
    }
}
