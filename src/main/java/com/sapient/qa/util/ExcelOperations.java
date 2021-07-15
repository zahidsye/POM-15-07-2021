package com.sapient.qa.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.CellType;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ExcelOperations {

    Sheet sheet;
    Workbook wb;

    public ExcelOperations(String filePath, String sheetName) {
        File file = new File(filePath);
        try {
            wb = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheet(sheetName);
    }

    public HashMap<String, String> getCellData(int rowNum) {
        HashMap<String, String> hm = new HashMap<String, String>();
        for (int i = 0; i < getColCount(); i++) {
            sheet.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
            hm.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNum).getCell(i).toString());
        }
        return hm;
    }

    public Object[][] getTestData() {
        Object[][] obj = new Object[getRowCount()][1];
        for (int i = 1; i <= getRowCount(); i++) {
            HashMap<String, String> testData = getCellData(i);
            obj[i - 1][0] = testData;
        }
        return obj;
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }
}
