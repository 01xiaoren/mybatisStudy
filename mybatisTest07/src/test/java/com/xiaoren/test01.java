package com.xiaoren;

import com.xiaoren.mapper.EmpMapper;
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
import java.util.Date;

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
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int i = mapper.addInsert(new Emp(null, "TOM", "SALESMAN", 7521, new Date(), 2314.0, 100.0, 10));
        if (i < 0) {
            System.out.println("失败");
        } else {
            System.out.println("成功");
        }
        sqlSession.commit();
    }

    @Test
    public void updateEnameByEmpno() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int i = mapper.updateEnameByEmpno(7844, "TOM");
        if (i < 0) {
            System.out.println("失败");
        } else {
            System.out.println("成功");
        }
        sqlSession.commit();
    }

    @Test
    public void deleteByEmpno() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int i = mapper.deleteByEmpno(7939);
        if (i < 0) {
            System.out.println("失败");
        } else {
            System.out.println("成功");
        }
        sqlSession.commit();
    }

    @After
    public void release() {
        sqlSession.close();
    }
}

