package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TODO
 * {@code @datetime} 2022/5/22 8:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationCourse {
    private int id;
    private int studentId;
    private int courseId;
    private int evaluation;
}
