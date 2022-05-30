package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TODO
 * {@code @datetime} 2022/5/2 22:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health {
    private int id;
    private int studentId;
    private Double height;
    private Double weight;
    private String remark;
}
