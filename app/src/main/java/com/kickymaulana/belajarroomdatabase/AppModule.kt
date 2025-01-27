package com.kickymaulana.belajarroomdatabase

import androidx.room.Room
import com.kickymaulana.belajarroomdatabase.userlist.UserListRepository
import com.kickymaulana.belajarroomdatabase.userlist.UserListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MyDatabase::class.java,
            "user_database"
        ).build()
    }

    // UserDao
    single { get<MyDatabase>().userDao() }

    // UserListRepository
    singleOf(::UserListRepositoryImpl) { bind<UserListRepository>()}

    // UserListViewModel
    singleOf(::UserListViewModel)
}