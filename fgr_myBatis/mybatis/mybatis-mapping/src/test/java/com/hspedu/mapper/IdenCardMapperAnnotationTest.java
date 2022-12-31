package com.hspedu.mapper;

import com.hspedu.entity.IdenCard;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class IdenCardMapperAnnotationTest {
    private SqlSession sqlSession;
    private IdenCardMapperAnnotation idenCardMapperAnnotation;

    //编写方法 完成初始化  @Before表示执行目标测试方法前会执行该方法
    @Before
    public void init(){
        //获取sqlSession
        sqlSession = MyBatisUtils.getSqlSession();
        //获取MonsterMapper代理对象 底层使用动态代理机制
        idenCardMapperAnnotation = sqlSession.getMapper(IdenCardMapperAnnotation.class);
        System.out.println("idenCardMapperAnnotation =" + idenCardMapperAnnotation.getClass());
    }

    @Test
    public void getIdenCardById(){
        IdenCard idenCard = idenCardMapperAnnotation.getIdenCardById(1);

        System.out.println("注解 idenCard= " + idenCard);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

    }
}
