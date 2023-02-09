package com.xiaoren;

import com.xiaoren.mapper.DeptMapper;
import com.xiaoren.pojo.Dept;
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

public class test01 {
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
    public void testAddInsert() {
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null, "小任学院", "杭州");
        System.out.println(dept.getDeptno());
        mapper.addDept(dept);
        sqlSession.commit();
        System.out.println(dept.getDname());


    }

    @After
    public void release() {
        sqlSession.close();
    }
}
