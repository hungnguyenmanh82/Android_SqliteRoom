package com.hung.sqliteroom.dao;

import com.hung.sqliteroom.entity.EmployeeView;

import java.util.List;

import androidx.room.*;

@Dao
@SkipQueryVerification
public interface EmployeeViewDAO {

    @Query("SELECT * FROM EmployeeView")
    List<EmployeeView> getAll();

    /**
     * https://www.w3schools.com/sql/sql_like.asp
     * http://www.sqlitetutorial.net/sqlite-like/
     */
    @Query("SELECT * FROM EmployeeView WHERE name LIKE :name LIMIT 2")
    List<EmployeeView> findByName(String name);

    @Query("SELECT * FROM employee WHERE id = :id")
    EmployeeView findById(int id);

}