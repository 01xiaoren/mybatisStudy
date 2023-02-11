package com.xiaoren;


import com.xiaoren.mapper.DeptMapper;
import com.xiaoren.pojo.Dept;
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
    public void findDeptByDeptno() {
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = (Dept) deptMapper.findDeptByDeptno(20);
/*        System.out.println(dept.getDeptno());
        System.out.println(dept.getDname());
        System.out.println(dept.getLoc());*/
        //延迟记载的测试；延迟加载时不能输出或者get另一个需求文件
        dept.getEmpList().forEach(System.out::println);
    }


    @After
    public void release() {
        sqlSession.close();
    }
}

