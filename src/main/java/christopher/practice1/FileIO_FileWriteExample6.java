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
public class FileIO_FileWriteExample6 {
    public static void main(String args[]) throws IOException{
    String filename="C:/Users/Bluesky/Desktop/4.txt";
    //BufferedWriter bufferedWriter=new BufferedWriter();
        //FileWriter fileWriter=new FileWriter(filename,true);
        FileWriter fileWriter = new FileWriter(filename);
            //FileWriter fileWriter=new FileWriter(filename,true);
            for(int i=0;i<10;i++)
            {
                fileWriter.write("Line"+i+"\r\n");
            }
        fileWriter.close();
    }
}
