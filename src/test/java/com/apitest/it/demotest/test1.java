package com.apitest.it.demotest;

import com.apitest.it.VO.ExcelResultVo;
import com.apitest.it.dataprovider.test1DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;

public class test1 {

    @Test
    public void testOne(){
        System.out.println("aabbcc");
    }

    @Test
    public void testSecond(){
        System.out.println("bbccdd");
    }

    @Test(dataProvider = "testThrid", dataProviderClass = test1DataProvider.class)
    public void testThrid(HashMap map, String code){
        Assert.assertEquals(1,1);
    }
}
