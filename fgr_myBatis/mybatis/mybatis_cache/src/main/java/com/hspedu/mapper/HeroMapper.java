package com.hspedu.mapper;

import com.hspedu.entity.Hero;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface HeroMapper {

    //添加hero
    public void addHero(Hero hero);

    //查询rank大于10的所有hero，如果输入的rank不大于0，则输出所有hero
    public List<Hero> findHeroByRank(@Param(value = "rank") Integer rank);

    //查询rank为3，6，10【rank可变】的hero
    public List<Hero> findHeroByVarRank( List<Integer> ranks);

    //修改hero信息，如果没有设置新的属性值，则保持原来的值
    public void updateHero(Hero hero);

    //根据id查询hero 如果没有传入id 返回搜友hero
    public List<Hero> findHeroById(Integer id);
}
