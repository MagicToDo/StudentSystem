package com.liu.studentmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TODO
 * {@code @datetime} 2022/4/30 2:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

        private int id;
        private int studentId;
        private String name;
        private String injectionDate;
        private String info;

}
