package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Course
 * @Description None
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;
    private String name;
    private int clazzId;
    private int teacherId;
    private String courseDate;
    private String info;
    private String changename;

}
