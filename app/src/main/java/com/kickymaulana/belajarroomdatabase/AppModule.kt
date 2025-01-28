package com.kickymaulana.belajarroomdatabase

import com.kickymaulana.belajarroomdatabase.userlist.UserListRepository
import com.kickymaulana.belajarroomdatabase.userlist.UserListViewModel
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

        retrofit.create(UserService::class.java)
    }

    single { UserListRepository(get()) }

    viewModel { UserListViewModel(get()) }
}