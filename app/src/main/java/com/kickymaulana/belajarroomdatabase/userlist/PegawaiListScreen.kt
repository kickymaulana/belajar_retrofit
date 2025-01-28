package com.kickymaulana.belajarroomdatabase.userlist

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import org.koin.androidx.compose.koinViewModel

@Composable
fun PegawaiListScreen(navController: NavController, viewModel: PegawaiListViewModel = koinViewModel()) {

    //val list_pegawai by viewModel.users.collectAsStateWithLifecycle()
    val lazyPagingItems = viewModel.users.collectAsLazyPagingItems()
//    val lazyPagingItems = viewModel.users.collectAsStateWithLifecycle(
//        initialValue = TODO(),
//        lifecycle = TODO(),
//        minActiveState = TODO(),
//        context = TODO()
//    )


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("create")
                },
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }

        }

    ) { scaffoldPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(scaffoldPadding)
        ) {

            if(lazyPagingItems.loadState.prepend is LoadState.Loading){
                item{
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                        CircularProgressIndicator()

                    }
                }
            }

            items(
                count = lazyPagingItems.itemCount,
                contentType = lazyPagingItems.itemContentType { "contentType" }
            ) { index ->
                lazyPagingItems[index]?.let {
                    Card(modifier = Modifier.fillParentMaxWidth()) {
                        Column(modifier = Modifier.padding(6.dp)) {
                            Text(text = "Nama : ${it.nama}")
                            Text(text = "Alamat : ${it.alamat}")
                        }
                    }
                }
                Spacer(Modifier.height(6.dp))
            }

            if(lazyPagingItems.loadState.append is LoadState.Loading){
                item{
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                        CircularProgressIndicator()

                    }
                }
            }
//            items(10) {
//                Card(modifier = Modifier.fillParentMaxWidth()) {
//                    Column(modifier = Modifier.padding(6.dp)) {
//                        Text(text = "Nama : Kicky Maulaana")
//                        Text(text = "Alamat : Sei Balai")
//                    }
//                }
//                Spacer(Modifier.height(6.dp))
//            }

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
    //PegawaiListScreen()
}
