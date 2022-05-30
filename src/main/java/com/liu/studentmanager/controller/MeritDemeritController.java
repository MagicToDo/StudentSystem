package com.liu.studentmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TODO
 * {@code @datetime} 2022/5/3 0:30
 */
@Controller
@RequestMapping("/meritdemerit")
public class MeritDemeritController {

    @GetMapping("/meritdemerit_list")
    public String meritDemeritList(){return "meritde/meritdemerit";}
}
