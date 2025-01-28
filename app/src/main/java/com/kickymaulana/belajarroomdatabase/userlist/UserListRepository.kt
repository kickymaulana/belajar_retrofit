package com.kickymaulana.belajarroomdatabase.userlist

import com.kickymaulana.belajarroomdatabase.User
import com.kickymaulana.belajarroomdatabase.UserService

class UserListRepository(private val userService: UserService) {
    suspend fun getUsers(): List<User> {
        return userService.getUsers()
    }
}