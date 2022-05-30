package com.liu.studentmanager.controller;

import com.liu.studentmanager.domain.EvaluationCourse;
import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.domain.Student;
import com.liu.studentmanager.service.CourseService;
import com.liu.studentmanager.service.EvaluationCourseService;
import com.liu.studentmanager.util.AjaxResult;
import com.liu.studentmanager.util.Const;
import com.liu.studentmanager.util.Data;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/5/3 1:35
 */

@Controller
@RequestMapping("/evaluationcourse")
public class EvaluationCourseController {

    @GetMapping("/evaluationCourse_list")
    public String evaluationCourse(){return ("evaluation/evaluationcourse");}

    @Autowired
    private EvaluationCourseService evaluationCourseService;

    @Autowired
    private CourseService courseService;


    /**
     * 异步加载信息列表
     * @param page
     * @param rows
     * @param studentid
     * @param from
     * @return
     */
    @PostMapping("/getEvaluationCourseList")
    @ResponseBody
    public Object getEvaluationCourseList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                  @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                                  @RequestParam(value = "studentid", defaultValue = "0")String studentid ,
                                  String from,
                                  HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!studentid.equals("0")) { paramMap.put("studentId",studentid);}
        PageBean<EvaluationCourse> pageBean = evaluationCourseService.queryPage(paramMap);

//        判断是家长还是学生权限
        Student student = (Student) session.getAttribute(Const.STUDENT);
        Patriarch patriarch=(Patriarch) session.getAttribute(Const.PATRIARCH);
        if(!ObjectUtils.isEmpty(student)){
            //是学生权限，只能查询自己的信息
            paramMap.put("studentId",student.getId());
        }else if (!ObjectUtils.isEmpty(patriarch)){
            paramMap.put("studentId",patriarch.getStudentId());
        }

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
     * 添加信息
     * @param evaluationCourse
     * @return
     */
    @PostMapping("/addEvaluationCourse")
    @ResponseBody
    public AjaxResult addEvaluationCourse(@RequestBody EvaluationCourse evaluationCourse){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = evaluationCourseService.addEvaluationCourse(evaluationCourse);
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
     * @param evaluationCourse
     * @return
     */
    @PostMapping("/editEvaluationCourse")
    @ResponseBody
    public AjaxResult editEvaluationCourse(EvaluationCourse evaluationCourse){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = evaluationCourseService.editEvaluationCourse(evaluationCourse);
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

    //删除信息
    @PostMapping("/deleteEvaluationCourse")
    @ResponseBody
    public AjaxResult deleteEvaluationCourse(@RequestBody Data data){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            int count = evaluationCourseService.deleteEvaluationCourse(data.getIds());
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
            ajaxResult.setMessage("删除失败");
        }
        return ajaxResult;
    }



}
