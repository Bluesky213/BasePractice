/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Christopher
 */

public class ExcelIODemo {
	public static void main(String[] args) throws IOException {

        FileInputStream in = null;  
        FileOutputStream out = null;
        //定义一个Workbook对象
        Workbook wb = null;
        String IN_WORKBOOK_NAME = "E:/test.xlsx";
        String OUT_WORKBOOK_NAME = "E:/test1.xlsx";

        try {  
            in = new FileInputStream(IN_WORKBOOK_NAME);  
            //输入流传入wb对象
            wb = new XSSFWorkbook(in);
            //如果是xls文件，则new HSSFWorkbook(in);
            //获取sheet
            Sheet sheet = wb.getSheetAt(0);
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();
            String[] appendix = {"--原型设计","--前端开发","--后端开发","--测试"};
            int rownum = 0;
            String str = null;
            //字符串拼接
            for(int i=firstRow;i<lastRow;i++) {
                //获取行
                Row row = sheet.getRow(i);
                //获取单元格
                Cell cell = row.getCell(0);
                try {
                    //获取单元格的值
                    str = cell.getStringCellValue();                    
                } catch (NullPointerException e) {
                    //如果单元格为空，就跳过此次循环
                    continue;
                }

                for(int j=0;j<appendix.length;j++) {
                    Row row2 = sheet.getRow(rownum);
                    //如果获取不到现有的行，就新建一行		
                    if(row2==null) {
                        row2=sheet.createRow(rownum);
                    }
                    Cell cell2 = row2.getCell(1);
                    //同理
                    if(cell2==null) {
                        cell2 = row2.createCell(1);
                    }
                    cell2.setCellValue(str+appendix[j]);
                    rownum++;
                }
            }
            //先关闭输入流，再new一个输出流
            in.close(); 
            out = new FileOutputStream(OUT_WORKBOOK_NAME);
            //再用wb写到输出流
            wb.write(out);
            out.close();
        } catch (IOException e) {  
            System.out.println(e.toString());  
        }  finally {  
           wb.close(); 
        }  

        System.out.println("====================操作成功====================");  
    }
}
