package com.uim.autoapi.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtils {

    public static SqlSession getSqlSession() {
        SqlSession sqlsession = null;
        try {
            //获取配置的资源文件
            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
            //得到SqlSessionFactory，使用类加载器加载xml文件
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
            sqlsession = factory.openSession();
        }catch (IOException e){
            e.printStackTrace();
        }
        return sqlsession;
    }
}
