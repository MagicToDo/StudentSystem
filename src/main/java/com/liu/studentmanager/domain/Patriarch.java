package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TODO
 * {@code @datetime} 2022/5/3 2:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patriarch {
    private int id;
    private int studentId;
    private String relation;
    private String password;
}
