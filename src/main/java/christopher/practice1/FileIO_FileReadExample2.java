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
public class FileIO_FileReadExample2 {
        public static void main(String []args) {
        String filename="C:/Users/Bluesky/Desktop/1.txt";//文件中的汉字无法读出
        try{
            BufferedReader read=new BufferedReader(new FileReader(filename));
            String line=read.readLine();
            int c;
            while((c=read.read())!=-1)
            {   System.out.println(read.read());
                System.out.println(line);
                line=read.readLine();
             }
}
        catch (IOException e){
        System.out.println("Problem reading "+filename);
        }
    }
    
}
