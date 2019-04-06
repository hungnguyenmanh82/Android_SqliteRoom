package com.hung.sqliteroom.entity;

import androidx.annotation.NonNull;
import androidx.room.*;

/**
 * Nếu ko xác định tên table thì nó sẽ lấy tên class làm tên Table
 * SQL ko phan biệt chữ Hoa và Thường
 */

/*@Entity(foreignKeys = {
        @ForeignKey(entity = Employee.class,
                parentColumns = "id",
                childColumns = "managerId") })*/

/**
 * Dùng @ForeignKey la de tao contraint khi tao table SQL => nó sẽ check contraint khi insert du lieu vao
 * neu ko tim thay foreign key no se bao loi
 */
@Entity
public class Department {
    @PrimaryKey
    @NonNull
    public int id; //primary key
    /**
     * lay ten lam column name luon => phai dung Proguard de giu nguyen Ten khi compile
     */
    public String name;
    public int managerId;


    public Department(@NonNull int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "{"+ this.id + "," + this.name + "}";
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
