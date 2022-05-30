package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.Health;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HealthMapper {
    List<Health> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addHealth(Health health);

    int editHealth(Health health);
    //删除健康信息
    int deleteHealth(List<Integer> ids);
    //获得健康信息
    List<Health> getHealthById(List<Integer> ids);
    //通过id查询
    int findByHealth(int studentId);
}
