package com.uim.autoapi.test;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.automation.interfacetest.base.RestTemplateRequest;
//import com.automation.interfacetest.service.LoginService;

public class TestExcel {

    public static String token;

    @BeforeClass
    public void testBefore() throws Exception{
        System.out.printf("BeforeClass");
    }

//    @DataProvider(name="testData")
//    public static Object[][] data(Method method) throws Exception{
//        return ExcelUtils.getTestData("E:\\project\\autoapi\\excelDriver.xlsx","sheet1");
//    }

    @Test(dataProvider = "testData",description = "描述",groups = {"组位置"})
    public void test001(String rowNumber,
                        String testCaseName,
                        String url,
                        String params,
                        String environment,
                        String caseDescription
    ) throws Exception{
        JSONObject object = JSONObject.parseObject(params);
//        String result = RestTemplateRequest.postForObjectmap(url,object,token);
        String result = "111";
        System.out.println("打印结果:" + result);
    }


    @AfterClass
    public void testAfter() throws Exception{
        System.out.println("this is after class");
    }

}
