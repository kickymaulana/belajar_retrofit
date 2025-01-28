package com.kickymaulana.belajarroomdatabase

import com.kickymaulana.belajarroomdatabase.userlist.PegawaiListRepository
import com.kickymaulana.belajarroomdatabase.userlist.PegawaiListViewModel
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://678624ccf80b78923aa594f2.mockapi.io/api/v1/") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()

        retrofit.create(PegawaiService::class.java)
    }

    single { PegawaiListRepository(get()) }

    viewModel { PegawaiListViewModel(get()) }
}