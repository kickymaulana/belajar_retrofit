package com.kickymaulana.belajarroomdatabase.userlist

import com.kickymaulana.belajarroomdatabase.User
import com.kickymaulana.belajarroomdatabase.UserDao

interface UserListRepository {

    suspend fun getUsers(): List<User>

    suspend fun createUser(user: User)
}