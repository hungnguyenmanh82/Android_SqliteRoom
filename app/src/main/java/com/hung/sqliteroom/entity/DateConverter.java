/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hung.sqliteroom.entity;

import java.util.Date;

import androidx.room.TypeConverter;

/**
 * Neu Table dùng DateConvert thi:
 *  + khi write vào database neu la  Date no se tu dong chuyen doi ve Long de save vao database
 *  + khi read tu database neu la Long no se tu dong chuyen doi sang Date
 * Day la thiet ke moi (ko co o Hibernate)
 */
public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        //the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this date.
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        //the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this date.
        return date == null ? null : date.getTime();
    }
}
