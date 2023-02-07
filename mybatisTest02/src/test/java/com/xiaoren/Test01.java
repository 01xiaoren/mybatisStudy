package com.xiaoren;

import com.xiaoren.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test01 {
    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void testSelectOne() {
        // 查询单个对象
        System.out.println("查询单个对象");
        Emp emp = sqlSession.selectOne("findOne");
        System.out.println(emp);
    }

    @Test
    public void testSelectAll() {
        //list查询所有对象
        System.out.println("查询所有对象按");
        List<Emp> list = sqlSession.selectList("EmpMapper.findAll");
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectMap() {
        //查询对象map集合
        System.out.println("查询对象的map集合");
        Map<Integer, Emp> empMap = sqlSession.selectMap("findEmpMap", "EMPNO");
        Set<Integer> keySet = empMap.keySet();
        for (Integer emp : keySet) {
            System.out.println(emp + "：" + empMap.get(emp));
        }
    }

    @After
    public void release() {
        //关闭sqlSession
        sqlSession.close();
    }
}
