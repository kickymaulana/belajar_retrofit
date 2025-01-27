package com.kickymaulana.belajarroomdatabase.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kickymaulana.belajarroomdatabase.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserListViewModel(private val userListRepository: UserListRepository) : ViewModel() {

    private val _users: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val users: StateFlow<List<User>> get() = _users

    init {
        initialLoad()
    }

    fun initialLoad(){
        viewModelScope.launch {

            val userOne = User(
                firstName = "Kicky",
                lastName = "Maulana"
            )
            val userTwo = User(
                firstName = "Iriawan",
                lastName = "Panjaitan"
            )

            userListRepository.createUser(userOne)
            userListRepository.createUser(userTwo)

            val newUser = userListRepository.getUsers()
            _users.update { newUser }
        }

    }
}