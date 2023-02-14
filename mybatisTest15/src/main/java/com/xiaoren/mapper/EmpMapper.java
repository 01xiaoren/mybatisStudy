package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;

public interface EmpMapper {
    /**
     * 根据员工编号查询员工信息
     *
     * @param empno 员工编号
     * @return 员工编号对应的emp对象
     */
    Emp findEmpByEmpno(int empno);
}
