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

public class Test02 {
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
    public void TestSelect() {
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> list = mapper.FindAll();
        list.forEach(System.out::println);
    }


    @After
    public void release() {
        sqlSession.close();
    }
}

