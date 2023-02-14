package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    /**
     * 根据员工编号查询员工信息
     *
     * @param empno 员工编号
     * @return 员工编号对应的emp对象
     */
    Emp findEmpByEmpno(int empno);

    /***
     *测试二级缓存
     * @param deptno
     * @return  组合一个emp对象的list集合属性
     */
    List<Emp> findByDeptno(int deptno);
}
