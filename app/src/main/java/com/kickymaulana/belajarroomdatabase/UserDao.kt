package com.kickymaulana.belajarroomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertUser(user: User)
}