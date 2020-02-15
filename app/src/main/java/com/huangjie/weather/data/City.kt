package com.huangjie.weather.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @blame 黄杰
 * @version 2020-02-02 23:49
 * @author huangjie
 */

@Entity(tableName = "city")
data class City(
    @PrimaryKey @ColumnInfo(name = "_id") val plantId: Int,
    @ColumnInfo(name = "root") val root: String,
    @ColumnInfo(name = "parent") val parent: String,
    @ColumnInfo(name = "posID") val cityId: Int,
    @ColumnInfo(name = "name") val cityName: String,
    @ColumnInfo(name = "pinyin") val cityNameEn: String,
    @ColumnInfo(name = "x") val lon: String,
    @ColumnInfo(name = "y") val lat: String
) {

}