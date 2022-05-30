package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Health;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

public interface HealthService {
    PageBean<Health> queryPage(Map<String, Object> paramMap);

    int addHealth(Health health);

    int editHealth(Health health);

    int deleteHealth(List<Integer> ids);

    List<Health> getHealthById(List<Integer> ids);

    int findByHealth(int studentId);
}
