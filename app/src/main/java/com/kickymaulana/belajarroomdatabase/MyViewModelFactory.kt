package com.kickymaulana.belajarroomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kickymaulana.belajarroomdatabase.userlist.UserListRepository
import com.kickymaulana.belajarroomdatabase.userlist.UserListViewModel

class MyViewModelFactory constructor(private val repository: UserListRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserListViewModel::class.java!!)) {
            UserListViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}