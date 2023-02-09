package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    /***
     *该方法查询全部员工的信息
     * @return 全部员工信息emp对象的list集合
     */
    List<Emp> findAll();

    /***
     * 根基员工编号查询单个信息
     * @param empno  员工编号找到返回emp对象，找不到返回null
     * @return
     */
    Emp findByEmpno(int empno);

    /***
     * 根据员工部门和工资下限查询信息
     * @param deptno员工部门
     * @param sal薪资
     * @return 多个emp对象的list集合
     */
    List<Emp> findByDeptnoAndSal(int deptno员工部门, double sal薪资);
    //    List<Emp> findByDeptnoAndSal(@Param("deptno") int deptno, @Param("sal") double sal);

    List<Emp> findByDeptnoAndSal1(Map<String, Object> map);

    List<Emp> findByDeptnoAndSal2(Emp emp);
    List<Emp> findByDeptnoAndSal3(@Param("empa") Emp empa,@Param("empb") Emp empb);
//    List<Emp> findByDeptnoAndSal3 (Emp empa,Emp empb);
}
