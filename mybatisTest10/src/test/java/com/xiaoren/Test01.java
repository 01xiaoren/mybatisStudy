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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
        public void findEmpJoinDeptByEmpno(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empJoinDeptByEmpno = mapper.findEmpJoinDeptByEmpno(7499);
        System.out.println(empJoinDeptByEmpno);
    }

    @After
    public void release() {
        sqlSession.close();
    }
}

