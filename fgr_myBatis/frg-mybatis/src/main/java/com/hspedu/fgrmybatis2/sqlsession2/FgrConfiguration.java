package com.hspedu.fgrmybatis2.sqlsession2;

import com.hspedu.fgrmybatis2.config.Function;
import com.hspedu.fgrmybatis2.config.MapperBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class FgrConfiguration {

    private ClassLoader loader = ClassLoader.getSystemClassLoader();

    public Connection build(String resource){

        Connection connection = null;
        try {
            InputStream resourceAsStream = loader.getResourceAsStream(resource);
            SAXReader reader = new SAXReader();
            Document document = reader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            //写一个方法获取connection
            connection = evalDataSource(rootElement);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection evalDataSource(Element node){

        if (!"database".equals(node.getName())){
            throw new RuntimeException("所获取的根目录不是database");
        }
        System.out.println("node name=" + node.getName());
        String driverClassName = null;
        String url = null;
        String username = null;
        String password = null;

        List elements = node.elements();
        for (Object item : elements) {
            Element element = (Element) item;
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            if (name == null || value == null){
                throw new RuntimeException("节点property没有设置name或value属性");
            }
            switch (name){
                case "driverClassName":
                    driverClassName = value;
                    break;
                case "url":
                    url = value;
                    break;
                case "username":
                    username = value;
                    break;
                case "password":
                    password = value;
                    break;
                default:
                    throw new RuntimeException("属性名没有匹配到");
            }
        }
        Connection connection = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public MapperBean readMapper(String path){
        MapperBean mapperBean = new MapperBean();

        try {
            InputStream resourceAsStream = loader.getResourceAsStream(path);
            SAXReader reader = new SAXReader();
            Document document = reader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            String namespace = rootElement.attributeValue("namespace");
            mapperBean.setInterfaceName(namespace);

            Iterator iterator = rootElement.elementIterator();
            List<Function> list = new ArrayList<>();
            while(iterator.hasNext()){
                Element e = (Element)iterator.next();
                Function function = new Function();
                if ("select".equals(e.getName())){
                    function.setSqlType(e.getName());
                    function.setFuncName(e.attributeValue("id"));
                    //setResultType传入一个对象
                    String resultType = e.attributeValue("resultType");//全类名
                    Object instance = Class.forName(resultType).newInstance();
                    function.setResultType(instance);
                    function.setSql(e.getText());
                    list.add(function);
                }
            }
            mapperBean.setFunctions(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapperBean;
    }
}
