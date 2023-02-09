package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    /***
     * 增加员工信息
     * @param emp 存储新员工信息的Emp对象
     * @return 对数据库产生行数的影响
     */
    int addInsert(Emp emp);

    /***
     * 根据员工编号修改员工姓名
     * @param empno 员工编号
     * @param ename 员工姓名
     * @return 对数据库产生行数的影响
     */
    int updateEnameByEmpno(@Param("empno") int empno, @Param("ename") String ename);

    /**
     * 根据员工编号删除员工信息
     *
     * @param empno员工编号
     * @return 对数据库产生行数的影响
     */
    int deleteByEmpno(int empno);
}
