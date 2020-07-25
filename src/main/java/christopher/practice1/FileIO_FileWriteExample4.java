/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
//此程序存在写入中文乱码的问题

/**
 *
 * @author Bluesky
 */
public class FileIO_FileWriteExample4 {
    FileIO_FileWriteExample4 file=new FileIO_FileWriteExample4();
    public static void main(String []args) throws IOException{
    String filename="C:/Users/Bluesky/Desktop/5.txt";
    //FileWriter fileWriter=new FileWriter(filename);
    OutputStreamWriter fileWriter=new OutputStreamWriter(new FileOutputStream(filename,true),"gb2312");
    for(int i=0;;i++)
    {
        Scanner scanner=new Scanner(System.in);
        String get=scanner.nextLine();
        if(get.equals("close"))
        {
            fileWriter.close();
            System.out.println("The fileWriter has been closed!");
            break;
            
        }
        else
        {
            fileWriter.write(get);
            fileWriter.write("\r\n");
        }
    }
    }
}
