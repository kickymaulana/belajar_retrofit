package com.kickymaulana.belajarroomdatabase

import retrofit2.http.GET
import retrofit2.http.Query


interface PegawaiService {
    @GET("pegawai") // Ganti dengan endpoint yang sesuai
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<Pegawai>
}