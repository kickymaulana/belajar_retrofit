package com.kickymaulana.belajarroomdatabase.userlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserListScreen(modifier: Modifier, viewModel: PegawaiListViewModel = koinViewModel()){

    val list_pegawai by viewModel.users.collectAsStateWithLifecycle()

    Scaffold { scaffoldPadding ->
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(scaffoldPadding)) {

            items(list_pegawai) { pegawai ->
                Card(modifier = Modifier.fillParentMaxWidth()) {
                    Column(modifier = Modifier.padding(6.dp)) {
                        Text(text = "Nama : ${pegawai.nama}")
                        Text(text = "Alamat : ${pegawai.alamat}")
                    }
                }
                Spacer(Modifier.height(6.dp))
            }

        }

    }

}

@Composable
fun TestingScreen() {
    Text(text = "yang betul lah kau")

}

@Preview(showBackground = true)
@Composable
fun UserListScreenPreview() {
    //UserListScreen()
}
