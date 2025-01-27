package com.kickymaulana.belajarroomdatabase

import com.kickymaulana.belajarroomdatabase.userlist.UserListRepository

class UserListRepositoryImpl(private val userDao: UserDao): UserListRepository {
    override suspend fun getUsers(): List<User> {
        return userDao.getAll()
    }

    override suspend fun createUser(user: User) {
        userDao.insertUser(user)
    }
}