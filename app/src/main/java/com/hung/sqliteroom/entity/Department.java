package com.hung.sqliteroom.entity;

import androidx.annotation.NonNull;
import androidx.room.*;


/*@Entity(foreignKeys = {
        @ForeignKey(entity = Employee.class,
                parentColumns = "id",
                childColumns = "managerId") })*/

/**
 * Dùng Foreign Key constraint sẽ bị báo lỗi nếu Id ta chèn vào ko tồn tại
 */
@Entity
public class Department {
    @PrimaryKey
    @NonNull
    public int id; //primary key
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
