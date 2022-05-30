package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.EvaluationCourse;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @author 86662
 */
public interface EvaluationCourseService {
    PageBean<EvaluationCourse> queryPage(Map<String, Object> paramMap);

    int addEvaluationCourse(EvaluationCourse evaluationCourse);

    int editEvaluationCourse(EvaluationCourse evaluationCourse);

    int deleteEvaluationCourse(List<Integer> ids);

    List<EvaluationCourse> getEvaluationCourseById(List<Integer> ids);

//    int findByTitle(String Title);
}
