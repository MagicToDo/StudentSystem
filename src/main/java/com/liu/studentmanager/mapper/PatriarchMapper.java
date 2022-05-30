package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.Patriarch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PatriarchMapper {

        List<Patriarch> queryList(Map<String, Object> paramMap);

        Integer queryCount(Map<String, Object> paramMap);

        int addPatriarch(Patriarch patriarch);

        int editPatriarch(Patriarch patriarch);

        int deletePatriarch(List<Integer> ids);

        int editPswdByPatriarch(Patriarch patriarch);

        Patriarch findByPatriarch(Patriarch patriarch);
}
