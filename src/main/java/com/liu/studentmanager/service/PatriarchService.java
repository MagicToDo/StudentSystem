package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;


public interface PatriarchService {
    PageBean<Patriarch> queryPage(Map<String, Object> paramMap);

    int addPatriarch(Patriarch patriarch);

    int editPatriarch(Patriarch patriarch);

    int deletePatriarch(List<Integer> ids);

    int editPswdByPatriarch(Patriarch patriarch);

    Patriarch findByPatriarch(Patriarch patriarch);
}
