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
    public void findByCondition() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
//        emp.setEmpno(7521);
//        emp.setEname("SMITH");
//        emp.setEname("A");
        try {
            emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"));
            List<Emp> emps = mapper.findByCondition(emp);
            emps.forEach(System.out::println);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


    @After
    public void release() {
        sqlSession.close();
    }
}

