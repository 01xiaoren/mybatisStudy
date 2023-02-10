package com.xiaoren.mapper;

import com.xiaoren.pojo.Dept;

public interface DeptMapper {
    /**
     * 根据部门编号查询部门信息及该部分所有员工的信息
     * @param deptno 要查询的部门编号
     * @return 对象，内部组合一个emp的list的属性用于封装部门的所有信息
     */
    Dept findDeptJoinEmpsByDeptno(int deptno);
}
