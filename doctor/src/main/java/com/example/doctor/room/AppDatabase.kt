package com.example.doctor.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.doctor.room.dao.UserDao
import com.example.doctor.room.entity.User


@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDao

    companion object {
        var appDatabase: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = appDatabase ?: synchronized(LOCK) {
            appDatabase ?: buildDatabase(context).also { appDatabase = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "bookDocDB.db"
        )
            .build()
    }

}
