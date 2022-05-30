package com.liu.studentmanager.interceptors;

import com.liu.studentmanager.domain.Admin;
import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.domain.Student;
import com.liu.studentmanager.domain.Teacher;
import com.liu.studentmanager.util.Const;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname LoginInterceptor
 * @Description 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Admin user = (Admin)request.getSession().getAttribute(Const.ADMIN);
        Teacher teacher = (Teacher)request.getSession().getAttribute(Const.TEACHER);
        Student student = (Student)request.getSession().getAttribute(Const.STUDENT);
        Patriarch patriarch = (Patriarch)request.getSession().getAttribute(Const.PATRIARCH);
        if(!ObjectUtils.isEmpty(user) || !ObjectUtils.isEmpty(teacher) || !ObjectUtils.isEmpty(student)|| !ObjectUtils.isEmpty(patriarch)){
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/system/login");
        return false;
    }

}
