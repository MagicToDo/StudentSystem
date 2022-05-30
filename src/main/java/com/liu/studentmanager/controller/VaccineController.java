package com.liu.studentmanager.controller;

import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.domain.Student;
import com.liu.studentmanager.domain.Vaccine;
import com.liu.studentmanager.service.VaccineService;
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
 * {@code @datetime} 2022/4/30 3:13
 */
@Controller
@RequestMapping("/vaccine")
public class VaccineController {


        @Autowired
        private VaccineService vaccineService;

        @GetMapping("/vaccine_list")
        public String vaccineList(){
            return "vaccine/vaccineList";
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
        @PostMapping("/getVaccineList")
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
            Student student = (Student) session.getAttribute(Const.STUDENT);
            Patriarch patriarch=(Patriarch) session.getAttribute(Const.PATRIARCH);
            if(!ObjectUtils.isEmpty(student)){
                //是学生权限，只能查询自己的信息
                paramMap.put("studentId",student.getId());
            }else if (!ObjectUtils.isEmpty(patriarch)){
                paramMap.put("studentId",patriarch.getStudentId());
            }

            PageBean<Vaccine> pageBean = vaccineService.queryPage(paramMap);
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
         * @param vaccine
         * @return
         */
        @PostMapping("/addVaccine")
        @ResponseBody
        public AjaxResult addVaccine(Vaccine vaccine){
            AjaxResult ajaxResult = new AjaxResult();
            try {
                int count = vaccineService.addVaccine(vaccine);
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
         * @param vaccine
         * @return
         */
        @PostMapping("/editVaccine")
        @ResponseBody
        public AjaxResult editVaccine(Vaccine vaccine){
            AjaxResult ajaxResult = new AjaxResult();
            try {
                int count = vaccineService.editVaccine(vaccine);
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


        @PostMapping("/deleteVaccine")
        @ResponseBody
        public AjaxResult deleteVaccine(@RequestBody Data data){
            AjaxResult ajaxResult = new AjaxResult();
            try {
                int count = vaccineService.deleteVaccine(data.getIds());
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
