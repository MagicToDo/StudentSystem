package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.GrowFoot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GrowFootMapper {
    List<GrowFoot> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addGrowFoot(GrowFoot growFoot);

    int editGrowFoot(GrowFoot growFoot);

    int deleteGrowFoot(List<Integer> ids);

    List<GrowFoot> getGrowFootById(List<Integer> ids);

    int findByTitle(String Title);
}
