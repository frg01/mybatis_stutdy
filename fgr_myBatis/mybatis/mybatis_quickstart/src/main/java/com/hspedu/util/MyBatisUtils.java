package com.hspedu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 工具类 得到sqlSession
 */
public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //编写静态代码块 初始化SqlSessionFactory
    static{
        try {
            //指定资源文件 配置文件
            String resource = "mybatis-config.xml";
            //互殴去到配置文件对应的inputStream
            //加载文件时 默认到resource目录  运行后的工作目录
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            System.out.println("SqlSessionFactory" + sqlSessionFactory.getClass());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //编写方法，返回SqlSession对象-会话
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
