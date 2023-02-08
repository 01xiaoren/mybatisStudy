package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;

import java.util.List;
public interface EmpMapper {
    /**
     * 该方法用于查询全部的员工信息
     * @return 全部员工信息封装的Emp对象的List集合
     */
    List<Emp> findAll();
}