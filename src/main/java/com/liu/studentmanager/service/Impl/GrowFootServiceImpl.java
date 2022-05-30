package com.liu.studentmanager.service.Impl;

import com.liu.studentmanager.domain.GrowFoot;
import com.liu.studentmanager.mapper.GrowFootMapper;
import com.liu.studentmanager.service.GrowFootService;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/5/2 21:01
 */
@Service
public class GrowFootServiceImpl  implements GrowFootService {
    @Autowired
    private GrowFootMapper growFootMapper;

    @Override
    public PageBean<GrowFoot> queryPage(Map<String, Object> paramMap) {
        PageBean<GrowFoot> pageBean = new PageBean<>((Integer)
                paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<GrowFoot> datas = growFootMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = growFootMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addGrowFoot(GrowFoot growFoot) {
        return growFootMapper.addGrowFoot(growFoot);
    }

    @Override
    public int editGrowFoot(GrowFoot growFoot) {
        return growFootMapper.editGrowFoot(growFoot);
    }

    @Override
    public int deleteGrowFoot(List<Integer> ids) {
        return growFootMapper.deleteGrowFoot(ids);
    }

    @Override
    public List<GrowFoot> getGrowFootById(List<Integer> ids) {
        return growFootMapper.getGrowFootById(ids);
    }

    @Override
    public int findByTitle(String title) {
        return growFootMapper.findByTitle(title);
    }


}
