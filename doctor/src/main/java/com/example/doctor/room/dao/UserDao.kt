package com.example.doctor.room.dao

import androidx.room.*
import com.example.doctor.room.entity.User


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsername(user: User)

    @Update
    fun updateUserName(user: User)

    @Delete
    fun deleteUserame(user: User)

    @Query("SELECT * FROM User WHERE username = :name")
    fun getPasswordByUserName(name: String): User

    @Query("SELECT * FROM User")
    fun getUsers(): List<User>
}
