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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testSingleArg() {
        // 测试单个基本数据类型作为参数
        Emp findByEmpno = sqlSession.selectOne("findByEmpno", 7499);
        System.out.println(findByEmpno);
    }

    @Test
    public void testMapArg() {
        // 测试Map集合作为参数
        Map<String, Object> args = new HashMap<>();
        args.put("deptno", 20);
        args.put("sal", 3000.0);
        List<Emp> emp = sqlSession.selectList("findEmpByDeptnoAndSal", args);
        emp.forEach(System.out::println);
    }
    @Test
    public void testEmpArg(){
        // 测试Map集合作为参数
        Emp arg =new Emp();
        arg.setDeptno(10);
        arg.setSal(2000.0);
        List<Emp> emps = sqlSession.selectList("findEmpByDeptnoAndSal2", arg);
//        emps.forEach(System.out::println);
        for (Emp emp :emps){
            System.out.println(emp);
        }
    }

    @After
    public void release() {
        //关闭sqlSession
        sqlSession.close();
    }
}
