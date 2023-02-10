package com.xiaoren;


import com.xiaoren.mapper.ProjectMapper;
import com.xiaoren.pojo.Project;
import com.xiaoren.pojo.ProjectRecord;
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
    public void findProjectJoinEmpsByPid() {
        ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
        Project empsByPid = mapper.findProjectJoinEmpsByPid(2);
        System.out.println(empsByPid);
        System.out.println("------------");
        List<ProjectRecord> projectRecordList = empsByPid.getProjectRecordList();
        for (ProjectRecord pw :
                projectRecordList) {
            System.out.println(pw
            );
        }
    }


    @After
    public void release() {
        sqlSession.close();
    }
}

