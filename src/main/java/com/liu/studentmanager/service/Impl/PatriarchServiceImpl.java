package com.liu.studentmanager.service.Impl;

import com.liu.studentmanager.domain.Patriarch;
import com.liu.studentmanager.mapper.PatriarchMapper;
import com.liu.studentmanager.service.PatriarchService;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/5/3 3:29
 */
@Service
public class PatriarchServiceImpl implements PatriarchService {
    @Autowired
    private PatriarchMapper patriarchMapper;

    @Override
    public PageBean<Patriarch> queryPage(Map<String, Object> paramMap) {
        PageBean<Patriarch> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Patriarch> datas = patriarchMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = patriarchMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int deletePatriarch(List<Integer> ids) {
        return patriarchMapper.deletePatriarch(ids);
    }

    @Override
    public int addPatriarch(Patriarch patriarch) {
        return patriarchMapper.addPatriarch(patriarch);
    }

    @Override
    public int editPatriarch(Patriarch patriarch) {
        return patriarchMapper.editPatriarch(patriarch);
    }


    @Override
    public int editPswdByPatriarch(Patriarch patriarch) {
        return patriarchMapper.editPswdByPatriarch(patriarch);
    }

    /**
     * @param patriarch
     * @return
     */
    @Override
    public Patriarch findByPatriarch(Patriarch patriarch) {
        Patriarch p=patriarchMapper.findByPatriarch(patriarch);
        return patriarchMapper.findByPatriarch(patriarch);
    }

}
