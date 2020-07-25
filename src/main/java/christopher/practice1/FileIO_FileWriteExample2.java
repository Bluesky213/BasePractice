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
public class FileIO_FileWriteExample2 {
    public static void main(String []args)throws IOException{
        //String一个字符串变量用于存储文件的目录，如果存在则写入，没有则创建1.txt并写入
    String filename="C:/Users/Bluesky/Desktop/1.txt";//
    //实例化一个FileWriter的对象writer，FileWriter(filename)
    FileWriter writer=new FileWriter(filename);
    //使用writer这个对象来调用write()方法，方法里传入要写进.txt文件中的字符串
    writer.write("写入文本测试\r\n");//写入文本的字符串里面加上“\r\n”起到换行的作用
    writer.write("这是输入的第一行\r\n");
    writer.write("这是输入的第二行\r\n");
    writer.write("成功了，你真棒");
    //最后调用close()来关闭一个写入流
    writer.close();//如果不写这一行文本就不会成功写入
    }
}
