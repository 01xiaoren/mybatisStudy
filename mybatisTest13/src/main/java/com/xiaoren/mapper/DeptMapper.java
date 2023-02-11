package com.xiaoren.mapper;

import com.xiaoren.pojo.Dept;

public interface DeptMapper {
    Dept findDeptByDeptno(int deptno);
}
