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

    /***
     *缓存：
     * 一种临时储存少量数据至内存或者磁盘中的一门技术，减少对数据的加载，降低工作量，提高程序响应速率
     * mybatis缓存将查询的sql语句执行后储存到内存中或者某种缓存介质；
     * 下一次执行相同的sql语句时；不需要sql语句与数据库进行交换，直接从换内存中拿取数据，减少对服务器的压力；
     * 特别是较多的数据查询下，缓存命中越高的情况下；使用缓存明显看到性能优化
     *
     * mybatis的一级缓存：
     * sqlSession缓存，默认开启，内存型缓存；实体类不要求序列化(Serializable)
     * 缓存中的数据使用键值对的形式存在hash值作为键；查询的结果作为值；
     * 在进行删改时： sqlSession.commit()会自动清空缓存
     */
    @Test
    public void TestEmp() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empByEmpno = mapper.findEmpByEmpno(7499);
        System.out.println(empByEmpno);

        EmpMapper mapper1 = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper1.findEmpByEmpno(7521));

        System.out.println(mapper == mapper1);
        System.out.println(empByEmpno == mapper.findEmpByEmpno(7521));
    }


    @After
    public void release() {
        sqlSession.close();
    }
}

