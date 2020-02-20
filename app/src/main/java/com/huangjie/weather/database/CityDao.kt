package com.huangjie.weather.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.huangjie.weather.data.City

/**
 * @blame 黄杰
 * @version 2020-02-08 23:17
 * @author huangjie
 */
@Dao
interface CityDao {

    @Insert(onConflict = REPLACE)
    fun save(city: City)

    @Query("SELECT * FROM city WHERE _id=:cityId LIMIT 1")
    suspend fun load(cityId: Int): City

    @Query("SELECT * FROM city")
    suspend fun loadAllCity(): MutableList<City>

}