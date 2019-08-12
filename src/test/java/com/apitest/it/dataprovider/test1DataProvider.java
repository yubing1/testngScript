package com.apitest.it.dataprovider;

import com.apitest.it.VO.ExcelResultVo;
import com.apitest.it.base.ReadExcel;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;

public class test1DataProvider {

    private ReadExcel readExcel = new ReadExcel();

    @DataProvider(name = "testThrid")
    public Iterator<Object[]> testThrid() throws IOException {
        Iterator<Object[]> iterator = readExcel.readExcel("aa.xls", "5555");
        System.out.println("数据已经读取了！");
        return iterator;
    }
}
