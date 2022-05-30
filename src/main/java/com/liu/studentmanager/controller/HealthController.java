package com.liu.studentmanager.controller;

import com.liu.studentmanager.domain.Health;
import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.domain.Student;
import com.liu.studentmanager.service.HealthService;
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
 * {@code @datetime} 2022/5/2 23:36
 */
@Controller
@RequestMapping("/health")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/health_list")
    public String healthList(){
        return "health/healthList";
    }

    /**
     * 异步加载疫苗信息列表
     * @param page
     * @param rows
     * @param name
     * @param studentid
     * @param from
     * @return
     */
    @PostMapping("/getHealthList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               @RequestParam(value = "studentid", defaultValue = "0")String studentid ,
                               String remark,
                               HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!studentid.equals("0")) { paramMap.put("studentId",studentid);}

        //判断是家长还是学生权限
        Student student = (Student) session.getAttribute(Const.STUDENT);
        Patriarch patriarch=(Patriarch) session.getAttribute(Const.PATRIARCH);
        if(!ObjectUtils.isEmpty(student)){
            //是学生权限，只能查询自己的信息
            paramMap.put("studentId",student.getId());
        }else if (!ObjectUtils.isEmpty(patriarch)){
            paramMap.put("studentId",patriarch.getStudentId());
        }

        PageBean<Health> pageBean = healthService.queryPage(paramMap);
        if(!ObjectUtils.isEmpty(remark) && remark.equals("combox")){
            return pageBean.getDatas();
        }else{
            Map<String,Object> result = new HashMap();
            result.put("total",pageBean.getTotalsize());
            result.put("rows",pageBean.getDatas());
            return result;
        }
    }

    /**
     * 添加疫苗信息
     * @param health
     * @return
     */
    @PostMapping("/addHealth")
    @ResponseBody
    public AjaxResult addHealth(Health health){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = healthService.addHealth(health);
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
     * @param health
     * @return
     */
    @PostMapping("/editHealth")
    @ResponseBody
    public AjaxResult editHealth(Health health){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = healthService.editHealth(health);
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


    @PostMapping("/deleteHealth")
    @ResponseBody
    public AjaxResult deleteHealth(Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = healthService.deleteHealth(data.getIds());
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
