package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Course;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseService
 * @Description None
 */
public interface CourseService {
    PageBean<Course> queryPage(Map<String, Object> paramMap);

    int addCourse(Course course);

    int editCourse(Course course);

    int deleteCourse(List<Integer> ids);

    List<Course> getCourseById(List<Integer> ids);

    int findByName(String name);
//通过课表?班级id
    boolean isClazzId(int id);
//通过班级查课表id
    List<Course> getAllBySid(int clazzid);
}
