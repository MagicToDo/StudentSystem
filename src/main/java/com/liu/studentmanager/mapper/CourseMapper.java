package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseMapper
 * @Description None
 */
@Mapper
public interface CourseMapper {
    List<Course> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addCourse(Course course);

    int editCourse(Course course);

    int deleteCourse(List<Integer> ids);

    List<Course> getCourseById(List<Integer> ids);

    int findByName(String name);

    List<Course> isClazzId(int id);
    //通过班级查课表id
    List<Course> getAllBySid(int clazzid);
}
