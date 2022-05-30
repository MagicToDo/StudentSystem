package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TODO
 * {@code @datetime} 2022/5/22 8:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationTeacher {
    private int id;
    private int studentId;
    private int teacherId;
    private String evalution;
}
