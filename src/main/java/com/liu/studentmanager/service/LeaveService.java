package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Leave;
import com.liu.studentmanager.util.PageBean;

import java.util.Map;

/**
 * @Classname LeaveService
 * @Description None
 */
public interface LeaveService {
    PageBean<Leave> queryPage(Map<String, Object> paramMap);

    int addLeave(Leave leave);

    int editLeave(Leave leave);

    int checkLeave(Leave leave);

    int deleteLeave(Integer id);
}
