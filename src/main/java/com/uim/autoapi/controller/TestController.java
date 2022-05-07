package com.uim.autoapi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uim.autoapi.model.LoginCase;
import com.uim.autoapi.utils.DatabaseUtils;
import com.uim.autoapi.utils.DoPostUtils;
import com.uim.autoapi.utils.ExcelUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }


    @RequestMapping("/excute")
    @Test
    public void excute() throws IOException{
        //执行execl中的内容
        Date date = new Date();
        ExcelUtils excelUtils = new ExcelUtils();
        JSONObject rowData = excelUtils.getExcelData(1);

        DoPostUtils doPostUtils = new DoPostUtils();
        String result = doPostUtils.httpPostJson(rowData, rowData.getString("url"));

        Date date2 = new Date();
        Long time = date2.getTime()-date.getTime();
        System.out.println(rowData.get("url"));
        System.out.println(time);
//        JSONObject hashMap = JSON.parseObject(result, JSONObject.class);
        JSONObject data = JSON.parseObject(JSON.parseObject(result, JSONObject.class).get("result").toString());
        System.out.println(data.getString("sessionToken"));

        SqlSession session= DatabaseUtils.getSqlSession();
        LoginCase loginCase=session.selectOne("loginCase",1);

    }
}
