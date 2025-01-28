package com.kickymaulana.belajarroomdatabase.userlist

import androidx.paging.PagingSource
import com.kickymaulana.belajarroomdatabase.Pegawai
import com.kickymaulana.belajarroomdatabase.PegawaiPagingSource
import com.kickymaulana.belajarroomdatabase.PegawaiService

//class PegawaiListRepository(private val pegawaiService: PegawaiService) {
//    suspend fun getUsers(): List<Pegawai> {
//        return pegawaiService.getUsers()
//    }
//}

class PegawaiListRepository(private val pegawaiService: PegawaiService) {
    fun getUsers(): PagingSource<Int, Pegawai> {
        return PegawaiPagingSource(pegawaiService)
    }
}