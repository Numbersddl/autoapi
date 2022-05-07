package com.uim.autoapi.utils;

import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.geom.Area;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    public JSONObject getExcelData(int Num){
        JSONObject rowData =new JSONObject();

        try {
            FileInputStream fis = new FileInputStream("E:\\project\\autoapi\\excelDriver.xlsx");
//            String city;
            Area area=null;
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int firstRowNum = sheet.getFirstRowNum();
            int lastRowNum = sheet.getLastRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            int firstCellNum = firstRow.getFirstCellNum();
            int lastCellNum = firstRow.getLastCellNum();
            System.out.println("第一行行号：" + firstRowNum);
            System.out.println("最后一行行号：" + lastRowNum);
            System.out.println("第一列列号：" + firstCellNum);
            System.out.println("最后一列列号：" + lastCellNum);

            XSSFCell cell;

//            String No = sheet.getRow(0).getCell(i).getStringCellValue();


            //循环遍历赋值
            for (int i = 0; i < lastCellNum; i++) {
//                list.add(sheet.getRow(Num).getCell(i).getStringCellValue());
                cell = sheet.getRow(Num).getCell(i);
                cell.setCellType(CellType.STRING);
//                list.add(cell.getStringCellValue());
                rowData.put(sheet.getRow(0).getCell(i).getStringCellValue(), cell.getStringCellValue());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rowData;
    }

}
