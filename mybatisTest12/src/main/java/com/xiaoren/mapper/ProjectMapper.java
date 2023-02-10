package com.xiaoren.mapper;

import com.xiaoren.pojo.Project;

public interface ProjectMapper {
    Project findProjectJoinEmpsByPid(int pid);
}
