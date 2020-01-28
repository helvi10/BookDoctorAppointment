package com.example.doctor.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    @ColumnInfo
    val userName: String,
    @ColumnInfo
    val password: String
)
