package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> findByCondition(Emp emp);
}
