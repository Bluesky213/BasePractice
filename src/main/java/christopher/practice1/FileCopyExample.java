/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.*;

/**
 *
 * @author Bluesky
 */
class CopyMaker{
    String sourceName,destName;
    BufferedReader source;
    BufferedWriter dest;
    String line;
    private boolean openFiles(){
        try{source=new BufferedReader(new FileReader(sourceName));
        }
        catch(IOException iox){
        System.out.println("Problem opening"+sourceName);
        return false;
        }
         try{
         dest=new BufferedWriter(new FileWriter(destName));
         }   
         catch (IOException iox){
             System.out.println("Opening"+destName);
             return false;
        }
         return true;
    }
    private boolean copyFiles(){
    try {
        line=source.readLine();
        while(line!=null){
        dest.write(line);
        dest.newLine();
        line=source.readLine();
        }
    }
        catch (IOException iox){
                System.out.println("Problem reading or writing");
        return false;        
        }
    return true;
    }
    private boolean closeFiles(){
        boolean retVal=true;
        try{
        source.close();
        }
        catch (IOException iox){
            System.out.println("Problem closing"+sourceName);
            retVal=false;
        }
        try{
        dest.close();
        }
        catch (IOException iox){
        System.out.println("Problem closing"+destName);
        }
        return retVal;
    }
    public boolean copy(String src,String dst){
        sourceName=src;
        destName=dst;
        return openFiles()&&copyFiles()&&closeFiles();
    }
}

/**
 *
 * @author Bluesky
 */
public class FileCopyExample{
        public static void main(String []args){
            if(args.length==2)
            {
                new CopyMaker().copy(args[0],args[1]);
            }
            else{
            System.out.print("Please EnterFile names");
            }
        }
    }

