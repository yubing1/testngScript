package com.apitest.it.dataprovider;

import com.apitest.it.VO.ExcelResultVo;
import com.apitest.it.base.ReadExcel;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class test1DataProvider {

    private ReadExcel readExcel = new ReadExcel();

    @DataProvider(name = "testThrid")
    public Object[] testThrid() throws IOException {
        ExcelResultVo resultVo = readExcel.readExcel("aa.xls", "5555");
        return new ExcelResultVo[]{resultVo};
    }
}
