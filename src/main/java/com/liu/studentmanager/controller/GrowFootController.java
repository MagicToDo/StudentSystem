package com.liu.studentmanager.controller;

import com.liu.studentmanager.domain.GrowFoot;
import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.domain.Student;
import com.liu.studentmanager.service.GrowFootService;
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
 * {@code @datetime} 2022/5/2 5:30
 */
@Controller
@RequestMapping("/growfoot")
public class GrowFootController {

    @GetMapping("/growfoot_list")
    public String growFootList(){return "growfoot/growfootList";}

    @GetMapping("/admingrowfoot_list")
    public String growFoot(){return "growfoot/admingrowfootList";}

    @Autowired
    private GrowFootService growFootService;


    /**
     * 异步加载信息列表
     * @param page
     * @param rows
     * @param studentid
     * @param from
     * @return
     */
    @PostMapping("/getGrowFootList")
    @ResponseBody
    public Object getGrowFootList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                               @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                               String title,
                               @RequestParam(value = "studentid", defaultValue = "0")String studentid ,
                               String from,
                                  HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        if(!ObjectUtils.isEmpty(title)) { paramMap.put("title",title);}
        if(!studentid.equals("0")) { paramMap.put("studentId",studentid);}
        PageBean<GrowFoot> pageBean = growFootService.queryPage(paramMap);

        //判断是家长还是学生权限
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
     * @param growFoot
     * @return
     */
    @PostMapping("/addGrowFoot")
    @ResponseBody
    public AjaxResult addGrowFoot(@RequestBody GrowFoot growFoot){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = growFootService.addGrowFoot(growFoot);
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
     * @param growFoot
     * @return
     */
    @PostMapping("/editGrowFoot")
    @ResponseBody
    public AjaxResult editGrowFoot(GrowFoot growFoot){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            int count = growFootService.editGrowFoot(growFoot);
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
    @PostMapping("/deleteGrowFoot")
    @ResponseBody
    public AjaxResult deleteGrowFoot(@RequestBody Data data){
        AjaxResult ajaxResult = new AjaxResult();

        try {
            int count = growFootService.deleteGrowFoot(data.getIds());
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
