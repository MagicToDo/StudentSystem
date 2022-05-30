package com.liu.studentmanager.controller;

import com.liu.studentmanager.domain.Course;
import com.liu.studentmanager.service.CourseService;
import com.liu.studentmanager.util.AjaxResult;
import com.liu.studentmanager.util.Data;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname CourseController
 * @Description None
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course_list")
    public String courseList(){
        return "course/courseList";
    }

    /**
     * 异步加载课程信息列表
     * @param page
     * @param rows
     * @param name
     * @param teacherid
     * @param from
     * @return
     */
    @PostMapping("/getCourseList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               String name,
                               @RequestParam(value = "clazzid", defaultValue = "0")String clazzid,
                               @RequestParam(value = "teacherid", defaultValue = "0")String teacherid ,
                               String from){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!ObjectUtils.isEmpty(name)) { paramMap.put("name",name);}
        if(!clazzid.equals("0")) { paramMap.put("clazzId",clazzid);}
        if(!teacherid.equals("0")) { paramMap.put("teacherId",teacherid);}
        PageBean<Course> pageBean = courseService.queryPage(paramMap);
        if(!ObjectUtils.isEmpty(from) && from.equals("combox")){
            return pageBean.getDatas();
        }else{
            Map<String,Object> result = new HashMap();
            result.put("total",pageBean.getTotalsize());
            result.put("rows",pageBean.getDatas());
            return result;
        }
    }

    /**
     * 添加课程信息
     * @param course
     * @return
     */
    @PostMapping("/addCourse")
    @ResponseBody
    public AjaxResult addCourse(Course course){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = courseService.addCourse(course);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("添加成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("添加失败");
        }
        return ajaxResult;
    }


    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @PostMapping("/editCourse")
    @ResponseBody
    public AjaxResult editCourse(Course course){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = courseService.editCourse(course);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("修改成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改失败");
        }
        return ajaxResult;
    }


    @PostMapping("/deleteCourse")
    @ResponseBody
    public AjaxResult deleteCourse(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = courseService.deleteCourse(data.getIds());
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("删除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("删除失败,该班级存在老师或学生");
        }
        return ajaxResult;
    }

    /**
     * 通过 课程id 查询 课程
     * @param clazzid
     * @return
     * 通过 课表信息中的班级id 查询 班级课程
     * 通过 班级课程中的班级id 查询 学生
     */
    @RequestMapping("/getClazzCourseList")
    @ResponseBody
    public Object getClazzCourseList(@RequestParam(value = "clazzid", defaultValue = "0")String clazzid){
        //通过班级id 查询 课表信息

        List<Course> courseList = courseService.getAllBySid(Integer.parseInt(clazzid));

        List<Integer> ids = new ArrayList<>();
        for(Course course : courseList){
            ids.add(course.getId());
        }
        return courseService.getCourseById(ids);

    }

}
