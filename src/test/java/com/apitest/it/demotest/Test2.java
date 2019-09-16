package com.apitest.it.demotest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {

    @BeforeMethod
    public void testBefore() {
        System.out.println("这是Test2的before");
    }

    @Test
    public void testOne() throws InterruptedException {
        System.out.println("aabbcc");
        System.out.println(System.currentTimeMillis());
        Thread.sleep(2000);
    }

    @Test
    public void testSecond() throws InterruptedException {
        System.out.println("aabbcc");
        System.out.println(System.currentTimeMillis());
        Thread.sleep(2000);
    }

    @Test
    public void testThird() throws InterruptedException {
        System.out.println("aabbcc");
        System.out.println(System.currentTimeMillis());
        Thread.sleep(2000);
    }
}
