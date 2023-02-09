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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testFindAll() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> all = mapper.findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }
    }

    @Test
    public void testFindByEmpno() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp byEmpno = mapper.findByEmpno(7349);
        System.out.println(byEmpno);
    }

    @Test
    public void findByDeptnoAndSal() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> byDeptnoAndSal = mapper.findByDeptnoAndSal(10, 1500.0);
        byDeptnoAndSal.forEach(System.out::println);
    }

    @Test
    public void findByDeptnoAndSal1() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Map<String, Object> objectObjectMap = new HashMap<>();
        objectObjectMap.put("deptno", 20);
        objectObjectMap.put("sal", 3000.0);
        List<Emp> byDeptnoAndSal1 = mapper.findByDeptnoAndSal1(objectObjectMap);
        byDeptnoAndSal1.forEach(System.out::println);
    }

    @Test
    public void findByDeptnoAndSal2() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(3000.0);
        List<Emp> byDeptnoAndSal2 = mapper.findByDeptnoAndSal2(emp);
        for (Emp list : byDeptnoAndSal2) {
            System.out.println(list);
        }
    }

    @Test
    public void findByDeptnoAndSal3() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp();
        emp1.setDeptno(20);
        Emp emp2 = new Emp();
        emp2.setSal(2000.0);
        List<Emp> byDeptnoAndSal3 = mapper.findByDeptnoAndSal3(emp1, emp2);
        byDeptnoAndSal3.forEach(System.out::println);
    }

    @After
    public void release() {
        sqlSession.close();
    }
}
