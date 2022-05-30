package com.liu.studentmanager.service.Impl;

import com.liu.studentmanager.domain.EvaluationCourse;
import com.liu.studentmanager.mapper.EvaluationCourseMapper;
import com.liu.studentmanager.service.EvaluationCourseService;
import com.liu.studentmanager.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author TODO
 * {@code @datetime} 2022/5/26 12:53
 */
@Service
public class EvaluationCourseServiceImpl implements EvaluationCourseService {
    @Autowired
    private EvaluationCourseMapper evaluationCourseMapper;

    @Override
    public PageBean<EvaluationCourse> queryPage(Map<String, Object> paramMap) {
        PageBean<EvaluationCourse> pageBean = new PageBean<>((Integer)
                paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<EvaluationCourse> datas = evaluationCourseMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = evaluationCourseMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }

    @Override
    public int addEvaluationCourse(EvaluationCourse evaluationCourse) {
        return evaluationCourseMapper.addEvaluationCourse(evaluationCourse);
    }

    @Override
    public int editEvaluationCourse(EvaluationCourse evaluationCourse) {
        return evaluationCourseMapper.editEvaluationCourse(evaluationCourse);
    }

    @Override
    public int deleteEvaluationCourse(List<Integer> ids) {
        return evaluationCourseMapper.deleteEvaluationCourse(ids);
    }

    @Override
    public List<EvaluationCourse> getEvaluationCourseById(List<Integer> ids) {
        return evaluationCourseMapper.getEvaluationCourseById(ids);
    }
//
//    @Override
//    public int findByTitle(String title) {
//        return evaluationCourseMapper.findByTitle(title);
//    }
}
