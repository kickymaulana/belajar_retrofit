package com.kickymaulana.belajarroomdatabase

import retrofit2.http.GET

interface PegawaiService {
    @GET("pegawai") // Replace with the actual endpoint
    suspend fun getUsers(): List<Pegawai>
}