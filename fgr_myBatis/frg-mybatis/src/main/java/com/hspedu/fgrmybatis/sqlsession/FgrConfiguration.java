package com.hspedu.fgrmybatis.sqlsession;

import com.hspedu.fgrmybatis.config.Function;
import com.hspedu.fgrmybatis.config.MapperBean;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
 * 读取xml，建立连接
 */
public class FgrConfiguration {

    //属性 类的加载器
    private static ClassLoader loader = ClassLoader.getSystemClassLoader();

    //读取xml文件信息 进行处理
    public Connection build(String resource) {

        Connection connection = null;
        try {
            //先加载配置文件 后去inputStream流
            InputStream stream = loader.getResourceAsStream(resource);
            //解析配置文件fgr_mybatis.xml
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            System.out.println("root=" + root.getName());
            //解析root 返回Connection
            connection = evalDataSource(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    //解析fgr_mybatis.xml  返回连接
    private Connection evalDataSource(Element node)  {
        if (!"database".equals(node.getName())) {
            throw new RuntimeException("root 节点应为database");
        }
        String driverClassName = null;
        String url = null;
        String username = null;
        String password = null;

        //遍历弄得下的子节点
        for (Object item : node.elements("property")) {
            Element i = (Element) item;
            String name = i.attributeValue("name");
            String value = i.attributeValue("value");
            //判断是否得到了name和value
            if (name == null || value == null) {
                throw new RuntimeException("节点property没有设置name或value属性");
            }
            switch (name) {
                case "url":
                    url = value;
                    break;
                case "username":
                    username = value;
                    break;
                case "password":
                    password = value;
                    break;
                case "driverClassName":
                    driverClassName = value;
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

    //读取XxxMapper.xml 能够创建MapperBean对象  path xml的路径(以类加载路径计算)
    //如果xxxMapper.xml放在resource目录下，直接传入xml文件名即可
    public MapperBean readMapper(String path) {
        MapperBean mapperBean = new MapperBean();

        try {
            InputStream stream = loader.getResourceAsStream(path);
            //dom4j
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element rootElement = document.getRootElement();
            System.out.println("root=" + rootElement);
            //获得namespace
            String namespace = rootElement.attributeValue("namespace");
            //设置mapperBean的InterfaceName
            mapperBean.setInterfaceName(namespace);
            //对rootElement的迭代器
            Iterator rootIterator = rootElement.elementIterator();
            //保存接口下的搜友方法信息
            List<Function> list = new ArrayList<>();
            //遍历子节点
            while(rootIterator.hasNext()){
                //取出一个子元素 dom4j
                Element e = (Element)rootIterator.next();
                //element的元素封装到Function并放入list
                Function function = new Function();
                function.setSqlType(e.getName());
                function.setFuncName(e.attributeValue("id"));
                    //setResultType传入一个对象
                String resultType = e.attributeValue("resultType");//全类名
                Object instance = Class.forName(resultType).newInstance();
                function.setResultType(instance);
                function.setSql(e.getText());
                list.add(function);
            }
            //将function的list设置到mapperBean
            mapperBean.setFunctions(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapperBean;
    }
}
