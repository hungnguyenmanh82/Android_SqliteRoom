package com.hung.sqliteroom.dao;

import com.hung.sqliteroom.entity.Department;
import com.hung.sqliteroom.entity.Employee;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * version: là database version, ko phỉa là Table version
 * Các Entity ở đây là các SQL table.
 * Nếu ko muốn tạo Table ở đây (vì đã tạo ở chỗ khác thì ko nên khai báo ở đây
 */
@Database(entities = {Employee.class, Department.class}, version = 2, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract EmployeeDAO getEmployeeDAO();
    public abstract DepartmentDAO getDepartmentDAO();

    /**
     * truy cập vao sql View
     */
    public abstract EmployeeViewDAO getEmployeeViewDAO();
}
