package com.liu.studentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TODO
 * {@code @datetime} 2022/5/22 8:07
 */
@Controller
@RequestMapping("/evaluationteacher")
public class EvaluationTeacherController {
    @GetMapping("/evaluationTeacher_list")
    public String evaluationCourse(){return ("evaluation/evaluationteacher");}
}
