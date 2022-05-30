package com.liu.studentmanager.service;


import com.liu.studentmanager.domain.GrowFoot;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

public interface GrowFootService {
    PageBean<GrowFoot> queryPage(Map<String, Object> paramMap);

    int addGrowFoot(GrowFoot growFoot);

    int editGrowFoot(GrowFoot growFoot);

    int deleteGrowFoot(List<Integer> ids);

    List<GrowFoot> getGrowFootById(List<Integer> ids);

    int findByTitle(String Title);
}
