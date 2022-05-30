package com.liu.studentmanager.service.Impl;

import com.liu.studentmanager.domain.Course;
import com.liu.studentmanager.mapper.CourseMapper;
import com.liu.studentmanager.service.CourseService;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname CourseServiceImpl
 * @Description None
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public PageBean<Course> queryPage(Map<String, Object> paramMap) {
        PageBean<Course> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Course> datas = courseMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = courseMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int editCourse(Course course) {
        return courseMapper.editCourse(course);
    }

    @Override
    public int deleteCourse(List<Integer> ids) {
        return courseMapper.deleteCourse(ids);
    }

    @Override
    public List<Course> getCourseById(List<Integer> ids) {
        return courseMapper.getCourseById(ids);
    }

    @Override
    public int findByName(String name) {
        return courseMapper.findByName(name);
    }

    @Override
    public boolean isClazzId(int id) {
        List<Course> courseList = courseMapper.isClazzId(id);
        if (courseList.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Course> getAllBySid(int clazzid) {
        return courseMapper.getAllBySid(clazzid);
    }

}
