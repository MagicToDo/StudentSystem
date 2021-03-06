package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Score;
import com.liu.studentmanager.domain.ScoreStats;
import com.liu.studentmanager.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * @Classname ScoreService
 * @Description None
 */
public interface ScoreService {
    PageBean<Score> queryPage(Map<String, Object> paramMap);

    boolean isScore(Score score);

    int addScore(Score score);

    int editScore(Score score);

    int deleteScore(Integer id);

    List<Score> getAll(Score score);

    ScoreStats getAvgStats(Integer courseid);
}
