package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.Score;
import com.liu.studentmanager.domain.ScoreStats;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Classname ScoreMapper
 * @Description None
 */
@Mapper
public interface ScoreMapper {
    List<Score> queryList(Map<String, Object> paramMap);

    Integer queryCount(Map<String, Object> paramMap);

    int addScore(Score score);

    Score isScore(Score score);

    int editScore(Score score);

    int deleteScore(Integer id);

    List<Score> getAll(Score score);

    ScoreStats getAvgStats(Integer courseid);
}
