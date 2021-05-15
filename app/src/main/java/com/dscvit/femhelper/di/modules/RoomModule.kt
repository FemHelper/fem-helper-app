package com.dscvit.femhelper.di.modules

import androidx.room.Room
import com.dscvit.femhelper.db.ChatsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(androidApplication(), ChatsDatabase::class.java, "chatsdb")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<ChatsDatabase>().chatsDao() }
}