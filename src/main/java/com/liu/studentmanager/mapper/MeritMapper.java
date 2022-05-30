package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.Merit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MeritMapper {
    List <Merit> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addMerit(Merit merit);

    int editMerit(Merit merit);

    int deleteMerit(List<Integer> ids);

    List<Merit> getMeritById(List<Integer> ids);
}
