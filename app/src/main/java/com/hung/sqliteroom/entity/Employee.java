package com.hung.sqliteroom.entity;

import java.util.Date;

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
 * Dùng Foreign Key constraint sẽ bị báo lỗi nếu Id ta chèn vào ko tồn tại
 */
@Entity
@TypeConverters(DateConverter.class)
public class Employee {
    /**
     * id se dc auto generate ở trên SQLite server
     */
    @PrimaryKey(autoGenerate = true)
    public int id;

    /**
     * Nếu ko có @columInfo thì sẽ lấy tên biến làm Column Name
     */
    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    /**
     * Nếu ko có @columInfo thì sẽ lấy tên biến làm Column Name
     */
    @ColumnInfo(name = "age")
    public int age;

    @ColumnInfo(name = "managerId")
    public int managerId;

    /**
     *  dùng @TypeConverters(DateConverter.class) => lưu ở SQlite dạng Long
     */
    public Date startTime;
    public Date endTime;
    /**
     * foreign key to Department table
     */
    @ColumnInfo(name = "deptId")
    public int deptId;

    public Employee(){}

    public Employee(@NonNull String name, int age, int managerId, Date startTime, Date endTime, int deptId) {
        this.name = name;
        this.age = age;
        this.managerId = managerId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "{"+ this.id + "," + this.name + "," + this.age + "," + this.managerId + "," + this.startTime.toString() + "," + this.deptId +"},";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
