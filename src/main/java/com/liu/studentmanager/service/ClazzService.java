package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Clazz;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname ClazzService
 * @Description None
 */
public interface ClazzService {
    PageBean<Clazz> queryPage(Map<String, Object> paramMap);

    int addClazz(Clazz clazz);

    int deleteClazz(List<Integer> ids);

    int editClazz(Clazz clazz);

    Clazz findByName(String clazzName);

    int findByClazz(String name);

}
