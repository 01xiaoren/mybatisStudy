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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test03 {
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
        sqlSession = factory.openSession(true);
    }

    //插入
    @Test
    public void testInsert() {
        Emp emp = new Emp(null, "按住啦Baby", "SALESMAN", 7839, new Date(), 3100.0, 200.0, 10);
        int addEmp = sqlSession.insert("addEmp", emp);
        System.out.println(addEmp);
        //手动提交事务
        // sqlSession.commit();
        /*增删改 要提交事务
         * sqlSession.commit();手动提交事务
         * sqlSession=factory.openSession(true); 设置事务自动提交
         * */

    }

    //修改
    @Test
    public void updateEmp() {
        Emp emp = new Emp();
        emp.setEname("小明");
        emp.setEmpno(7936);
        int updateEmp = sqlSession.update("updateEmp", emp);
        System.out.println(updateEmp);
    }

    //删除
    @Test
    public void deleteEmp() {

        int delete = sqlSession.delete("deleteEmp", 7936);
        if (delete == 0) {
            System.out.println("失败");
        } else {
            System.out.println("成功");
        }
    }

    @After
    public void release() {
        //关闭sqlSession
        sqlSession.close();
    }
}
