package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.EvaluationCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluationCourseMapper {

    List<EvaluationCourse> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addEvaluationCourse(EvaluationCourse evaluationCourse);

    int editEvaluationCourse(EvaluationCourse evaluationCourse);
    //删除信息
    int deleteEvaluationCourse(List<Integer> ids);
    //获得信息
    List<EvaluationCourse> getEvaluationCourseById(List<Integer> ids);
}

