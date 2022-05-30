package com.liu.studentmanager.service.Impl;

import com.liu.studentmanager.domain.Health;
import com.liu.studentmanager.mapper.HealthMapper;
import com.liu.studentmanager.service.HealthService;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/5/2 23:32
 */
@Service
public class HealthServiceImpl implements HealthService {
    @Autowired
    private HealthMapper healthMapper;

    @Override
    public PageBean<Health> queryPage(Map<String, Object> paramMap) {
        PageBean<Health> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Health> datas = healthMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = healthMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }



    @Override
    public int addHealth(Health health) {
        return healthMapper.addHealth(health);
    }

    @Override
    public int editHealth(Health health) {
        return healthMapper.editHealth(health);
    }

    @Override
    public int deleteHealth(List<Integer> ids) {
        return healthMapper.deleteHealth(ids);
    }

    @Override
    public List<Health> getHealthById(List<Integer> ids) {
        return healthMapper.getHealthById(ids);
    }

    @Override
    public int findByHealth(int studentId) {
        return healthMapper.findByHealth(studentId);
    }
}
