/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Bluesky
 */
public class FileIO_FileWriteExample3 {
    public static void main(String []args) throws IOException{
        String filename="C:/Users/Bluesky/Desktop/3.txt";
        BufferedWriter writer=new BufferedWriter(new FileWriter(filename));//建议需要写入大量的文本内容时使用BufferedWriter
        //将FIleWriter嵌套在BufferedWriter中
        writer.write("Hello!");
        writer.newLine();
        writer.write("This is another text file using BufferedWrite,");
        writer.newLine();
        writer.write("So I can use a common way to start a newLine");
        writer.close();
    }
}
