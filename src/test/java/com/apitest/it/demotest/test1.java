package com.apitest.it.demotest;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.apitest.it.dataprovider.test1DataProvider;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Locale;


public class test1 {

    @Test
    public void testOne(){
        System.out.println("aabbcc");
    }

    @Test
    public void testSecond(){
        Locale locale = new Locale("zh", "CN");
        Faker faker = new Faker(locale);
        System.out.println(faker.name().name());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.job().seniority());

        System.out.println("bbccdd");
    }

    @Test(dataProvider = "testThrid", dataProviderClass = test1DataProvider.class)
    public void testThrid(HashMap map, String code){
        Assert.assertEquals("e",code);
        System.out.println(map.toString());
        System.out.println(map.get("A").toString());
        JSONObject mapJson = new JSONObject(map);
        System.out.println(mapJson.toString());
    }
}
