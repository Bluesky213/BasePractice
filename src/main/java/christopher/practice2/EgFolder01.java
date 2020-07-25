/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Bluesky
 */
public class EgFolder01 {
	public static void main(String[] args) {
		new EgFolder01().transform("D:\\test\\");
	}
	public void transform(String path){
		File file = new File(path);
		
		File[] fs = file.listFiles();//listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组
		File[] fl;
		for(File fn: fs){
			copy(fs,fn.getAbsoluteFile());
		}
		
	}
	public static void copy(File[] fl, File file) {
	    if (!file.exists()) // 如果文件夹不存在  
	        file.mkdir(); // 建立新的文件夹  
	    System.out.println(file.getPath()+ File.separator + fl[1].getName());
	    System.out.println(file.getPath());
	    System.out.println(file.getPath()+ File.separator );
	    System.out.println(fl[1].getName());
	    for (int i = 0; i < fl.length; i++) {  
	        if (fl[i].isFile()) { // 如果是文件类型就复制文件  
	            try {  
	                FileInputStream fis = new FileInputStream(fl[i]);  
	                FileOutputStream out = new FileOutputStream(new File(file.getPath()+ File.separator + fl[i].getName()));  
	                 
	                int count = fis.available();  
	                byte[] data = new byte[count];  
	                if ((fis.read(data)) != -1) {  
	                    out.write(data); // 复制文件内容  
	                }  
	                out.close(); // 关闭输出流  
	                fis.close(); // 关闭输入流  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if (fl[i].isDirectory()) { // 如果是文件夹类型  
	            File des = new File(file.getPath() + File.separator  
	                    + fl[i].getName());  
	            des.mkdir(); // 在目标文件夹中创建相同的文件夹  
	            copy(fl[i].listFiles(), des); // 递归调用方法本身  
	        }  
	    }  
	}
}

