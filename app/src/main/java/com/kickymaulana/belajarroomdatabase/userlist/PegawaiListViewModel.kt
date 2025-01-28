package com.kickymaulana.belajarroomdatabase.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.kickymaulana.belajarroomdatabase.Pegawai
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//class PegawaiListViewModel(private val pegawaiListRepository: PegawaiListRepository) : ViewModel() {
//
//    private val _users: MutableStateFlow<List<Pegawai>> = MutableStateFlow(emptyList())
//    val users: StateFlow<List<Pegawai>> get() = _users
//    init {
//        initialLoad()
//    }
//    fun initialLoad(){
//        viewModelScope.launch {
//
//            val newUser = pegawaiListRepository.getUsers()
//            _users.update { newUser }
//        }
//    }
//}

class PegawaiListViewModel(private val pegawaiListRepository: PegawaiListRepository) : ViewModel() {

    val users = Pager(PagingConfig(pageSize = 10)) {
        pegawaiListRepository.getUsers()
    }.flow.cachedIn(viewModelScope)
}