package com.example.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.room.dao.CartDao
import com.example.data.local.room.entities.CartEntity

@Database(entities = [CartEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}