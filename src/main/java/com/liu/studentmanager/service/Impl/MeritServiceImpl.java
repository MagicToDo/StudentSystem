package com.liu.studentmanager.service.Impl;

import com.liu.studentmanager.domain.Merit;
import com.liu.studentmanager.mapper.MeritMapper;
import com.liu.studentmanager.service.MeritService;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/5/14 23:36
 */
@Service
public class MeritServiceImpl implements MeritService{

    @Autowired
    private MeritMapper meritMapper;


    /**
     * @param paramMap
     * @return
     */
    @Override
    public PageBean<Merit> queryPage(Map<String, Object> paramMap) {
        PageBean<Merit> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Merit> datas = meritMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = meritMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    /**
     * @param merit
     * @return
     */
    @Override
    public int addMerit(Merit merit) {
        return meritMapper.addMerit(merit);
    }

    /**
     * @param merit
     * @return
     */
    @Override
    public int editMerit(Merit merit) {
        return meritMapper.editMerit(merit);
    }

    /**
     * @param merit
     * @return
     */
    @Override
    public int deleteMerit(List<Integer> ids) {
        return meritMapper.deleteMerit(ids);
    }

    /**
     * @param ids
     * @return
     */
    @Override
    public List<Merit> getMeritById(List<Integer> ids) {
        return meritMapper.getMeritById(ids);
    }
}
