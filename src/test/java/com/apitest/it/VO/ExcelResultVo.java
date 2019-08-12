package com.apitest.it.VO;

import java.util.HashMap;

public class ExcelResultVo {
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

}
