package com.kickymaulana.belajarroomdatabase

import retrofit2.http.GET

interface UserService {
    @GET("users") // Replace with the actual endpoint
    suspend fun getUsers(): List<User>
}