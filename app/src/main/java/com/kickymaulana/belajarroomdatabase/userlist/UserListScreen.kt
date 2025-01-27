package com.kickymaulana.belajarroomdatabase.userlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.room.Room
import com.kickymaulana.belajarroomdatabase.MyDatabase
import com.kickymaulana.belajarroomdatabase.MyViewModelFactory

@Composable
fun UserListScreen(modifier: Modifier){

    val context = LocalContext.current
    val database = remember {
        Room.databaseBuilder(
            context = context,
            MyDatabase::class.java,
            "databaseku"
        ).build()
    }
    val userListRepository = remember {
        UserListRepository(database.userDao())
    }

    val factory = remember {
        MyViewModelFactory(userListRepository)
    }

    val viewModel = remember {
        ViewModelProvider(ViewModelStore(), factory)[UserListViewModel::class.java]
    }

    val users by viewModel.users.collectAsStateWithLifecycle()

    LazyColumn {
        items(users){ user ->
            Text(text = "Firstname : ${user.firstName}")
            Text(text = "Lastname : ${user.lastName}")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun UserListScreenPreview(){
    UserListScreen(modifier = Modifier)
}
