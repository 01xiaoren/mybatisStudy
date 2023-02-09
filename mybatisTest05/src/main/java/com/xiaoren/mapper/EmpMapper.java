package com.xiaoren.mapper;

import com.xiaoren.pojo.Emp;

import java.util.List;

public interface EmpMapper {
        /**
         * 根据名字字段你模糊查询
         * @return 名字
         */
        List<Emp> findByEname(String name);
}
