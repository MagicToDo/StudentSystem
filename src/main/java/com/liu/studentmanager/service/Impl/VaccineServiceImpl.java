package com.liu.studentmanager.service.Impl;

import com.liu.studentmanager.domain.Vaccine;
import com.liu.studentmanager.mapper.VaccineMapper;
import com.liu.studentmanager.service.VaccineService;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/4/30 3:19
 */
@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    private VaccineMapper vaccineMapper;

    @Override
    public PageBean<Vaccine> queryPage(Map<String, Object> paramMap) {
        PageBean<Vaccine> pageBean = new PageBean<>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Vaccine> datas = vaccineMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = vaccineMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }



    @Override
    public int addVaccine(Vaccine vaccine) {
        return vaccineMapper.addVaccine(vaccine);
    }

    @Override
    public int editVaccine(Vaccine vaccine) {
        return vaccineMapper.editVaccine(vaccine);
    }

    @Override
    public int deleteVaccine(List<Integer> ids) {
        return vaccineMapper.deleteVaccine(ids);
    }

    @Override
    public List<Vaccine> getVaccineById(List<Integer> ids) {
        return vaccineMapper.getVaccineById(ids);
    }

    @Override
    public int findByName(String name) {
        return vaccineMapper.findByName(name);
    }
}
