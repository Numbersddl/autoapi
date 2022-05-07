package com.uim.autoapi.utils;

import com.uim.autoapi.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigUtils {

    public static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);
    public static String getUrl(InterfaceName name){
        String address=bundle.getString("test.url");
        String uri="";
        String testUrl;

        if(name==InterfaceName.LOGIN){
            uri=bundle.getString("login.uri");
        }

        testUrl=address+uri;
        return testUrl;
    }
}
