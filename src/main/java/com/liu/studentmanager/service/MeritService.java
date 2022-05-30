package com.liu.studentmanager.service;


import com.liu.studentmanager.domain.Merit;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

public interface MeritService {

    PageBean<Merit> queryPage(Map<String,Object> paramMap);

    int addMerit(Merit merit);

    int editMerit(Merit merit);

    int deleteMerit(List<Integer> ids);

    List<Merit> getMeritById(List<Integer> ids);
}
