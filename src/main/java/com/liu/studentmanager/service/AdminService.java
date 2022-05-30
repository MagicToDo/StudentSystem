package com.liu.studentmanager.service;

import com.liu.studentmanager.domain.Admin;

/**
 * @Classname AdminService
 * @Description None
 */
public interface AdminService {

    Admin findByAdmin(Admin admin);


    int editPswdByAdmin(Admin admin);
}
