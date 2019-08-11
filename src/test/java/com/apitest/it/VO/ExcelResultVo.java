package com.apitest.it.VO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;

public class ExcelResultVo implements Iterator<Object[]> {
    private HashMap<String, Object> map = new HashMap<String, Object>();
    private String code;

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    public void forEachRemaining(Consumer<? super Object[]> action) {

    }
}
