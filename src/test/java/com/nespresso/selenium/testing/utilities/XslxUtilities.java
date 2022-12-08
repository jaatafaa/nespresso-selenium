package com.nespresso.selenium.testing.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XslxUtilities {

    public static FileInputStream inputStream;
    public static FileOutputStream outputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet xssfSheet;
    public static XSSFRow xssfRow;
    public static XSSFCell xssfCell;

    public static int getSheetRowCount(String xlsxFilePath, String workbookSheet) throws IOException {
        inputStream = new FileInputStream(xlsxFilePath);
        workbook = new XSSFWorkbook(inputStream);
        xssfSheet = workbook.getSheet(workbookSheet);
        int rowCount = xssfSheet.getLastRowNum();
        workbook.close();
        inputStream.close();

        return rowCount;
    }

    public static int getCellCount(String xlsxFilePath, String workbookSheet, int rowNumber) throws IOException {
        inputStream = new FileInputStream(xlsxFilePath);
        workbook = new XSSFWorkbook(inputStream);
        xssfSheet = workbook.getSheet(workbookSheet);
        xssfRow = xssfSheet.getRow(rowNumber);
        int cellCount = xssfRow.getLastCellNum();
        workbook.close();
        inputStream.close();

        return cellCount;
    }

    public static String getCellData(String xlsxFilePath, String workbookSheet, int rowNumber, int columnNumber) throws IOException {
        inputStream = new FileInputStream(xlsxFilePath);
        workbook = new XSSFWorkbook(inputStream);
        xssfSheet = workbook.getSheet(workbookSheet);
        xssfRow = xssfSheet.getRow(rowNumber);
        xssfCell = xssfRow.getCell(columnNumber);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(xssfCell);
        } catch (Exception exception) {
            data = "";
        }
        workbook.close();
        inputStream.close();
        return data;
    }

    public static void setCellData(String xlsxFilePath, String workbookSheet, int rowNumber, int columnNumber, String data) throws IOException {
        inputStream = new FileInputStream(xlsxFilePath);
        workbook = new XSSFWorkbook(inputStream);
        xssfSheet = workbook.getSheet(workbookSheet);
        xssfRow = xssfSheet.getRow(rowNumber);
        xssfCell = xssfRow.createCell(columnNumber);
        xssfCell.setCellValue(data);
        outputStream = new FileOutputStream(xlsxFilePath);

        workbook.write(outputStream);
        workbook.close();
        inputStream.close();
        outputStream.close();

    }
}
