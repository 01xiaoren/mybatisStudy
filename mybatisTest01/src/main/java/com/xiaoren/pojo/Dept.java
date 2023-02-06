package com.xiaoren.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//lombok注解形式
import java.io.Serializable;

//实体类
//注解形式
@Data//get与set方法
@AllArgsConstructor//全部参数的构造方法
@NoArgsConstructor//无参构造方法
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;


}
