package com.uim.autoapi.config;

import lombok.Data;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

@Data
public class TestConfig {
    //登陆接口uri
    public static String loginUrl;
    //声明http客户端
    public static DefaultHttpClient defaultHttpClient;
    //用来存储cookies信息的变量
    public static CookieStore store;
}
