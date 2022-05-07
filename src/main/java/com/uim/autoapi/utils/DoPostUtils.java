package com.uim.autoapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

public class DoPostUtils {

    public String httpPostJson(JSONObject jsonObject, String url){
        DefaultHttpClient httpClient = new DefaultHttpClient();
//        String url = "http://172.30.154.111:8088/web/v1/login";
        String result = null;
        HttpPost post = new HttpPost(url);
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(jsonObject.getString("params"),"UTF-8");
        post.setEntity(entity);
        try {
            HttpResponse response = httpClient.execute(post);
            result = EntityUtils.toString(response.getEntity(),"UTF-8");
            HashMap hashMap = JSON.parseObject(result, HashMap.class);
            System.out.println("");
            System.out.println(hashMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
