package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Vaccine;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

public interface VaccineService {
    PageBean<Vaccine> queryPage(Map<String, Object> paramMap);

    int addVaccine(Vaccine vaccine);

    int editVaccine(Vaccine vaccine);

    int deleteVaccine(List<Integer> ids);

    List<Vaccine> getVaccineById(List<Integer> ids);

    int findByName(String name);
}
