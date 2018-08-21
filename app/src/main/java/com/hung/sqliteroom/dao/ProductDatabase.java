package com.hung.sqliteroom.dao;

import com.hung.sqliteroom.entity.Product;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * version: là database version, ko phỉa là Table version
 */
@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDAO getProductDao();
}
