package com.kickymaulana.belajarroomdatabase.userlist

import com.kickymaulana.belajarroomdatabase.User

interface UserListRepository {

    suspend fun getUsers(): List<User>

    suspend fun createUser(user: User)
}