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
import java.util.List;

public class Test02 {
    private SqlSession sqlSession;
    private SqlSession sqlSession1;

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
        sqlSession1 = factory.openSession();
    }

    /***
     * mybatis的二级缓存：
     * 二级缓存是以namespace为标记的缓存，可以是由一个SqlSessionFactory创建的SqlSession之间共享缓存数据。
     * 默认并不开启。下面的代码中创建了两个SqlSession，执行相同的SQL语句，尝试让第二个SqlSession使用第一个SqlSession查询后缓存的数据。
     * 要求实体类必须实现序列化接口
     */
    @Test
    public void TestEmp() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> byDeptno = mapper.findByDeptno(30);
        byDeptno.forEach(System.out::println);
        //sqlSession提交后查询结果才会放进二级缓存中
        sqlSession.commit();

        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        List<Emp> byDeptno1 = mapper1.findByDeptno(30);
        byDeptno1.forEach(System.out::println);
    }


    @After
    public void release() {
        sqlSession.close();
    }
}

