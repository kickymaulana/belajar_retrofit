package com.kickymaulana.belajarroomdatabase.userlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserListScreen(modifier: Modifier, viewModel: UserListViewModel = koinViewModel()){

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
