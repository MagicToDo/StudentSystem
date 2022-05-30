package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Teacher;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname TeacherService
 * @Description None
 */
public interface TeacherService {
    PageBean<Teacher> queryPage(Map<String, Object> paramMap);
//删除教师
    int deleteTeacher(List<Integer> ids);

    int addTeacher(Teacher teacher);

    Teacher findById(Integer tid);

    int editTeacher(Teacher teacher);

    Teacher findByTeacher(Teacher teacher);

    int editPswdByTeacher(Teacher teacher);
}
