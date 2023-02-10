package com.xiaoren.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Integer pid;
    private String pname;
    private Integer money;
    // 组合一个ProjectRecord对象集合作为属性
    private List<ProjectRecord> projectRecordList;
}
