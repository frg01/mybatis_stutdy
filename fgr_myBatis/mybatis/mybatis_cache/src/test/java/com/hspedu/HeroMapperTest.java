package com.hspedu;

import com.hspedu.entity.Hero;
import com.hspedu.mapper.HeroMapper;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class HeroMapperTest {
    private SqlSession sqlSession;
    private HeroMapper heroMapper;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        heroMapper = sqlSession.getMapper(HeroMapper.class);
    }

    @Test
    public void addHero(){
        Hero hero = new Hero();
        hero.setNickname("杨青");
        hero.setRank(6);
        hero.setSkill("不知道");
        hero.setSalary(8000);
        hero.setEntry(new Date());

        heroMapper.addHero(hero);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("ok");
    }

    @Test
    public void findHeroByRank(){

        List<Hero> heros = heroMapper.findHeroByRank(-1);
        for (Hero hero : heros) {
            System.out.println("hero =" + hero);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("ok");
    }

    @Test
    public void findHeroByVarRank(){
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(13);
        integers.add(20);

        List<Hero> heros = heroMapper.findHeroByVarRank(integers);
        for (Hero hero : heros) {
            System.out.println("hero = " + hero);
        }
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("ok");
    }



    @Test
    public void updateHero(){
        Hero hero = new Hero();
        hero.setNickname("矮脚虎");
        hero.setId(8);

        heroMapper.updateHero(hero);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("ok");
    }

    @Test
    public void findHeroById(){
        List<Hero> heros = heroMapper.findHeroById(1);
        for (Hero hero : heros) {
            System.out.println("hero= " + hero);
        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("ok");
    }
}
