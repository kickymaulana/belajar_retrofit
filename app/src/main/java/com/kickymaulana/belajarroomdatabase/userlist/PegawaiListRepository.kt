package com.kickymaulana.belajarroomdatabase.userlist

import com.kickymaulana.belajarroomdatabase.Pegawai
import com.kickymaulana.belajarroomdatabase.PegawaiService

class PegawaiListRepository(private val pegawaiService: PegawaiService) {
    suspend fun getUsers(): List<Pegawai> {
        return pegawaiService.getUsers()
    }
}