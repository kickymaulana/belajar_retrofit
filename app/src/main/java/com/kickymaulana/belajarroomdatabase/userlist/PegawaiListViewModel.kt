package com.kickymaulana.belajarroomdatabase.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kickymaulana.belajarroomdatabase.Pegawai
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PegawaiListViewModel(private val pegawaiListRepository: PegawaiListRepository) : ViewModel() {

    private val _users: MutableStateFlow<List<Pegawai>> = MutableStateFlow(emptyList())
    val users: StateFlow<List<Pegawai>> get() = _users

    init {
        initialLoad()
    }

    fun initialLoad(){
        viewModelScope.launch {

            val newUser = pegawaiListRepository.getUsers()
            _users.update { newUser }
        }

    }
}