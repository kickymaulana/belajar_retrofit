package com.kickymaulana.belajarroomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}