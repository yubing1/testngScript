package com.apitest.it.base;

import com.apitest.it.VO.ExcelResultVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ReadExcel implements Iterator<Object[]> {

    public Iterator<Object[]> readExcel(String filePath, String sheetNumber) throws IOException {

        HashMap<String, Object> map = new HashMap<String, Object>();
        String filePathNew = "src/test/resources/dataprovider/" + filePath;
        Workbook workbook = null;
        InputStream inputStream = new FileInputStream(filePathNew);
        workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetNumber);
        Row row0 = sheet.getRow(0);
        Row row1 = sheet.getRow(1);
        Object[] objects = new Object[2];
        List<Object[]> list = new ArrayList<>();

        for (int i = 0; i < row0.getLastCellNum(); i++) {
            String key = row0.getCell(i).getStringCellValue();
            String value = row1.getCell(i).getStringCellValue();
            if (StringUtils.equals(key, "code")) {
                objects[1] = value;
                continue;
            }
            map.put(key, value);
            objects[0] = map;
        }
        list.add(objects);
        return list.iterator();
    }

    public void writeExcel() throws IOException {
        ExcelResultVo resultVo = new ExcelResultVo();
        HashMap<String, String> map = new HashMap<String, String>();

        String filePathNew = "src/test/resources/dataprovider/aa.xls" ;
        File xlsFile = new File(filePathNew);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("5555");
        for (int row = 0; row < 10; row++) {
            HSSFRow rows = sheet.createRow(row);
            for (int col = 0; col < 5; col++) {
                rows.createCell(col).setCellValue("data" + row + col);
            }
        }
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
    }

    @Test
    public void test() throws IOException {
        Iterator<Object[]> iterator = readExcel("aa.xls", "5555");


    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object[] next() {
        return new Object[0];
    }

    @Override
    public void remove() {

    }

    public void forEachRemaining(Consumer<? super Object[]> action) {

    }
}
