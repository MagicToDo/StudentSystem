package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TODO
 * {@code @datetime} 2022/5/14 22:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merit {
    private Integer id;
    private Integer studentId;
    private String smerit;
    private String smerity;
    private String sdeMerit;
    private String sdeMeritn;
}
