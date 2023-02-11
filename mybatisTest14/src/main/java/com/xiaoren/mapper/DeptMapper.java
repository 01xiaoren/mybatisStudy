package com.xiaoren.mapper;

import com.xiaoren.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptMapper {
    /**
     * 查询部门信息
     * * @return 组合一个Dept对象的集合属性
     */
    @Select("select * from dept")
    List<Dept> FindAll();

    /**
     * 根据部门编号查询部门信息
     *
     * @param deptno 部门编号
     * @return Dept对象
     */
    @Select("select * from dept where  deptno = #{deptno}")
    Dept FindById(@Param("id") int deptno);

    /***
     * 根据部门编号修改姓名和学院
     * @param dept  实体类dept
     * @return 对数据库行数的影响
     */
    @Update("update dept set dname=#{dname} ,loc = #{loc} where deptno = #{deptno}")
    int update(Dept dept);

    /**
     * 插入部门信息
     *
     * @param dept 对象的形式
     *             * @return 对数据库行数的影响
     */
    @Insert("insert into dept values (DEFAULT,#{dname},#{loc})")
    int insert(Dept dept);

    /***
     * 根据部门编号插入部门信息
     * @param deptno 部门编号
     * @return 产生对数据库行数的影响
     */

    @Delete("delete from dept where deptno = #{deptno}")
    int delete(int deptno);
}
