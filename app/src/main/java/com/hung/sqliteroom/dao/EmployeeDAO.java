package com.hung.sqliteroom.dao;

import com.hung.sqliteroom.entity.Employee;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface EmployeeDAO {

    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    /**
     * https://www.w3schools.com/sql/sql_like.asp
     * http://www.sqlitetutorial.net/sqlite-like/
     */
    @Query("SELECT * FROM employee WHERE name LIKE :name LIMIT 2")
    List<Employee> findByName(String name);

    @Query("SELECT * FROM employee WHERE id = :id")
    Employee findById(int id);

    @Insert
    void insertAll(List<Employee> employees);

    /**
     * update by Id
     * cach nay se update tat cả cac field của emp
     */
    @Update
    void update(Employee emp);

    /**
     * cach nay update 1 vai field du lieu
     */
    @Query("UPDATE employee SET name = :name, age= :age  WHERE id = :id")
    void update2(int id,String name, int age);

    @Delete
    void delete(Employee emp);
}