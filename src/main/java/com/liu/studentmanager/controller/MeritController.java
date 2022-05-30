package com.liu.studentmanager.controller;

import com.liu.studentmanager.domain.Merit;
import com.liu.studentmanager.service.MeritService;
import com.liu.studentmanager.util.AjaxResult;
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
 * {@code @datetime} 2022/5/14 23:46
 */
@Controller
@RequestMapping("/meritde")
public class MeritController {

    @GetMapping("/meritdemerit")
    public String meritList(){return "meritde/meritdemerit";}

    @GetMapping("/adminmeritdemerit")
    public String adminmeritList(){return "meritde/adminmeritdemerit";}

    @Autowired
    private MeritService meritService;

    @PostMapping("/getMeritList")
    @ResponseBody
    public Object getClazzList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               String name,
                               @RequestParam(value = "studentid", defaultValue = "0")String studentid ,
                               String from,
                               HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!ObjectUtils.isEmpty(name)) { paramMap.put("name",name);}
        if(!studentid.equals("0")) { paramMap.put("studentId",studentid);}

        //判断是家长还是学生权限
//        Student student = (Student) session.getAttribute(Const.STUDENT);
//        Patriarch patriarch=(Patriarch) session.getAttribute(Const.PATRIARCH);
//        if(!ObjectUtils.isEmpty(student)){
//            //是学生权限，只能查询自己的信息
//            paramMap.put("studentId",student.getId());
//        }else if (!ObjectUtils.isEmpty(patriarch)){
//            paramMap.put("studentId",patriarch.getStudentId());
//        }


        PageBean<Merit> pageBean = meritService.queryPage(paramMap);
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
     * 添加疫苗信息
     * @param merit
     * @return
     */
    @PostMapping("/addMerit")
    @ResponseBody
    public AjaxResult addMerit(Merit merit){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = meritService.addMerit(merit);
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
     * @param merit
     * @return
     */
    @PostMapping("/editMerit")
    @ResponseBody
    public AjaxResult editMerit(@RequestBody Merit merit){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = meritService.editMerit(merit);
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


    @PostMapping("/deleteMerit")
    @ResponseBody
    public AjaxResult deleteMerit(@RequestBody Data data){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = meritService.deleteMerit(data.getIds());
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
