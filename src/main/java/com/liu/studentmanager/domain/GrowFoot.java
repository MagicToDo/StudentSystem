package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TODO
 * {@code @datetime} 2022/5/2 20:24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrowFoot {
    private int id;
    private int clazzId;
    private int studentId;
    private String title;
    private String content;
    private String time;
    private String photo;
}
