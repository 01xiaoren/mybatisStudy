package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;

public interface EmpMapper {
    Emp findEmpJoinDeptByEmpno(int empno);
}
