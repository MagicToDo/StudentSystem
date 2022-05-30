package com.liu.studentmanager.controller;

import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.domain.Student;
import com.liu.studentmanager.service.PatriarchService;
import com.liu.studentmanager.service.StudentService;
import com.liu.studentmanager.util.AjaxResult;
import com.liu.studentmanager.util.Const;
import com.liu.studentmanager.util.Data;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/5/3 3:37
 */
@Controller
@RequestMapping("/patriarch")
public class PatriarchController {
    @Autowired
    private PatriarchService patriarchService;
    @Autowired
    private StudentService studentService;


    @RequestMapping("/patriarch_list")
    public String patriarchList(){
        return "/patriarch/patriarchList";
    }

    /**
     * 异步加载老师数据列表
     * @param page
     * @param rows
     * @param patriarchName
     * @param from
     * @param session
     * @return
     */
    @PostMapping("/getPatriarchList")
    @ResponseBody
    public Object getPatriarchList(@RequestParam(value = "page", defaultValue = "1")Integer page,
                                 @RequestParam(value = "rows", defaultValue = "100")Integer rows,
                                 String patriarchName,
                                 @RequestParam(value = "studentid", defaultValue = "0")String studentid,
                                 String from,
                                 HttpSession session){
        Map<String,Object> paramMap = new HashMap();
        paramMap.put("pageno",page);
        paramMap.put("pagesize",rows);
        //搜索条件
        if(!studentid.equals("0")) { paramMap.put("studentid",studentid);}


        //判断是老师还是学生权限还是家长
        Patriarch patriarch = (Patriarch) session.getAttribute(Const.PATRIARCH);
        if(!ObjectUtils.isEmpty(patriarch)){
            //是家长权限，只能查询学生和自己的信息
            Student student=new Student();
            paramMap.put("patriarchid",patriarch.getId());
            paramMap.put("studentid",student.getId());
        }

        PageBean<Patriarch> pageBean = patriarchService.queryPage(paramMap);
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
     * 删除教师
     * @param data
     * @return
     */
    @PostMapping("/deletePatriarch")
    @ResponseBody
    public AjaxResult deletePatriarch(Data data){
        AjaxResult ajaxResult = new AjaxResult();
            int count = patriarchService.deletePatriarch(data.getIds());
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("删除成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("删除失败");
            }
        return ajaxResult;
    }

    /**
     * 添加教师
     * @param files
     * @param patriarch
     * @return
     * @throws IOException
     */
    @RequestMapping("/addPatriarch")
    @ResponseBody
    public AjaxResult addPatriarch(@RequestParam("file") MultipartFile[] files, Patriarch patriarch) throws IOException {

        AjaxResult ajaxResult = new AjaxResult();
        //保存学生信息到数据库
        try{
            int count = patriarchService.addPatriarch(patriarch);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("保存成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("保存失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("保存失败");
        }

        ajaxResult.setSuccess(true);
        return ajaxResult;
    }

    @PostMapping("/editPatriarch")
    @ResponseBody
    public AjaxResult editPatriarch(@RequestParam("file") MultipartFile[] files,Patriarch patriarch){
        AjaxResult ajaxResult = new AjaxResult();

        try{
            int count = patriarchService.editPatriarch(patriarch);
            if(count > 0){
                ajaxResult.setSuccess(true);
                ajaxResult.setMessage("修改成功");
            }else{
                ajaxResult.setSuccess(false);
                ajaxResult.setMessage("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            ajaxResult.setSuccess(false);
            ajaxResult.setMessage("修改失败");
        }
        return ajaxResult;
    }
}
