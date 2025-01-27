package com.kickymaulana.belajarroomdatabase.userlist

import com.kickymaulana.belajarroomdatabase.User
import com.kickymaulana.belajarroomdatabase.UserDao

class UserListRepository(private val userDao: UserDao) {

    suspend fun getUsers(): List<User> {
        return userDao.getAll()
    }

    suspend fun createUser(user: User) {
        userDao.insertUser(user)
    }
}