package com.hung.sqliteroom.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Nếu ko xác định tên table thì nó sẽ lấy tên class làm tên Table
 * SQL ko phan biệt chữ Hoa và Thường
 */
@Entity
public class Product {

    /**
     * id se dc auto generate ở trên SQLite server
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;
    /**
     * Nếu ko có @columInfo thì sẽ lấy tên biến làm Column Name
     */
    @ColumnInfo(name = "image_url")
    private String imageUrl;

    // getters and setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
