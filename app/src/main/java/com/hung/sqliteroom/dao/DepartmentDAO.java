package com.hung.sqliteroom.dao;

import com.hung.sqliteroom.entity.Department;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DepartmentDAO {

    @Query("SELECT * FROM Department")
    List<Department> getAll();

    /**
     * https://www.w3schools.com/sql/sql_like.asp
     * http://www.sqlitetutorial.net/sqlite-like/
     */
    @Query("SELECT * FROM Department WHERE name LIKE :name LIMIT 2")
    List<Department> findByName(String name);

    @Query("SELECT * FROM Department WHERE id = :id")
    Department findById(int id);

    @Insert
    void insertAll(List<Department> departments);

    /**
     * update by Id
     * cach nay se update tat cả cac field của emp
     */
    @Update
    void update(Department dept);

    @Delete
    void delete(Department dept);
}