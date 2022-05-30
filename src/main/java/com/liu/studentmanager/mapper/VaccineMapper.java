package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.Vaccine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface VaccineMapper {
    
    List<Vaccine> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addVaccine(Vaccine vaccine);

    int editVaccine(Vaccine vaccine);
//删除疫苗信息
    int deleteVaccine(List<Integer> ids);
//获得疫苗信息
    List<Vaccine> getVaccineById(List<Integer> ids);
//通过课程名字查询
    int findByName(String name);
}
