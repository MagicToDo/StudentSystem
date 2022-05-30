package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname score
 * @Description 成绩实体表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer clazzId;
    private double score;
    private String remark;

    //关联表
    private String clazzName;
    private String courseName;
    private String studentName;

}
