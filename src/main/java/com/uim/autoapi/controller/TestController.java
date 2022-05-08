package com.uim.autoapi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uim.autoapi.mapper.ApiResultMapper;
import com.uim.autoapi.pojo.ApiResult;
import com.uim.autoapi.utils.DatabaseUtils;
import com.uim.autoapi.utils.DoPostUtils;
import com.uim.autoapi.utils.ExcelUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }


    @RequestMapping(value = "/excute/{num}")
    @Test
    public void excute(@PathVariable int num) {
        //执行execl中的内容
        ExcelUtils excelUtils = new ExcelUtils();
        JSONObject rowData = excelUtils.getExcelData(num);

        DoPostUtils doPostUtils = new DoPostUtils();
        String result = null;
        ApiResult apiResult = null;
        SqlSession sqlsession = null;
        ApiResultMapper mapper = null;
        try {
            result = doPostUtils.httpPostJson(rowData, rowData.getString("url"));
            if("fault".equals(result)){
                apiResult = new ApiResult();
                apiResult.setCasename(rowData.get("casename").toString());
                apiResult.setUrl(rowData.get("url").toString());
                apiResult.setTestresult("fail");
                apiResult.setTestversion("5.6.8.6811-RC02");
                apiResult.setExcutedate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                apiResult.setDescription("Description");
            }

//            JSONObject hashMap = JSON.parseObject(result, JSONObject.class);
            JSONObject data = JSON.parseObject(JSON.parseObject(result, JSONObject.class).get("result").toString());
            System.out.println(data.getString("sessionToken"));

            apiResult = new ApiResult();
            apiResult.setCasename(rowData.get("casename").toString());
            apiResult.setUrl(rowData.get("url").toString());
            apiResult.setTestresult("pass");
            apiResult.setTestversion("5.6.8.6811-RC02");
            apiResult.setExcutedate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            apiResult.setDescription("Description");
            sqlsession = DatabaseUtils.getSqlSession();
            sqlsession.getMapper(ApiResultMapper.class);
            mapper.insertApiResult(apiResult);
            sqlsession.commit();
        }catch (Exception e){
            apiResult.setTestresult("fail");
            mapper.insertApiResult(apiResult);
            sqlsession.commit();
        }

//        LoginCase loginCase=session.selectOne("loginCase",1);
//         ApiResult apiResult = session.selectOne("ApiResult");

//        int result = mapper.insertApiResult();

//        excuteResult.forEach(ApiResult -> System.out.println(ApiResult));
    }
}
