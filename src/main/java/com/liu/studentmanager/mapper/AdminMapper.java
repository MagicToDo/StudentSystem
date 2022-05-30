package com.liu.studentmanager.mapper;

import com.liu.studentmanager.domain.Admin;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description None
 */
@Repository
public interface AdminMapper {

    Admin findByAdmin(Admin admin);


    int editPswdByAdmin(Admin admin);
}
